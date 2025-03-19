# eshop
This project is monitoring real situation e-commercial company back-end project.
Please don't use the code on commercial purpose.
You have my thanks.
以下是为Cloudera Data Platform HBase迁移至华为云MRS HBase后设计的回退策略，结合HBase通用操作与华为云MRS特性：

---

### **一、迁移前备份策略**
1. **全量备份**  
   - 使用HBase自带工具导出表数据至HDFS或本地存储：  
     ```bash
     hbase org.apache.hadoop.hbase.mapreduce.Export '表名' /备份路径
     ```  
     备份文件需存储在安全位置（如华为云OBS或HDFS）。  
   - **华为云MRS补充**：通过FusionInsight Manager创建全量备份任务，确保备份路径与目标集群兼容。

2. **增量备份**  
   - 定期使用`hbase backup create incremental`创建增量备份，减少回退数据量。  
   - **华为云MRS补充**：启用跨集群拷贝功能，实时同步增量数据至原集群备用。

3. **元数据备份**  
   - 导出HBase配置文件（`hbase-site.xml`、`.META.`表结构）及集群拓扑信息。

---

### **二、回退触发条件**
- 数据不一致或业务异常（如写入失败、查询错误）。  
- 迁移后性能未达预期或存在兼容性问题。  
- 完全回退需求（如需恢复至迁移前状态）。

---

### **三、回退执行步骤**
#### **1. 停止新集群服务**
- 在华为云MRS中停止HBase服务及上层应用，避免数据写入冲突。  
- **注意**：需提前通知业务方暂停写入操作。

#### **2. 恢复原集群数据**
- **方式一：HBase原生工具恢复**  
  - 在原Cloudera集群上创建目标表结构。  
  - 使用`hbase org.apache.hadoop.hbase.mapreduce.Import`导入全量+增量备份数据。  
- **方式二：华为云MRS恢复**  
  - 通过FusionInsight Manager创建恢复任务，选择备份路径并指定恢复对象（HBase表）。  
  - 若备份存储于远端HDFS，需配置主备集群互信及跨集群拷贝。

#### **3. 验证数据完整性**
- 检查表元数据（`desc '表名'`）、数据量（`count '表名'`）及业务关键指标。  
- 对比迁移前后快照（Snapshot）或校验和（Checksum）。

#### **4. 启动原集群服务**
- 逐步恢复HBase及上层应用，监控日志排查异常。  
- **注意**：恢复后需重新配置业务连接信息（如ZooKeeper地址）。

---

### **四、回退后处理**
1. **清理新集群**  
   - 删除华为云MRS中已迁移的HBase集群，释放资源。  
2. **分析回退原因**  
   - 结合备份日志、监控数据定位迁移失败环节，优化后续迁移方案。  
3. **更新文档**  
   - 记录回退时间、操作人员及原因，纳入运维手册。

---

### **五、注意事项**
1. **版本兼容性**  
   - 确保备份数据与原集群HBase版本一致，避免恢复失败。  
2. **时间同步**  
   - 主备集群NTP服务需指向同一时间源，防止时间戳差异导致数据错乱。  
3. **业务影响**  
   - 回退期间业务需停用，需提前规划切换窗口。  

---

### **引用网页**
- HBase备份工具：  
- 华为云MRS恢复流程：  
- 版本降级与快照：  
- 数据一致性验证：
