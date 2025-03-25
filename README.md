### 华为云CDM迁移Cloudera HBase到MRS HBase业务割接过程

#### **一、全量数据迁移**
1. **环境准备**  
   - 创建与MRS集群网络互通的CDM集群，安全组、VPC、子网需一致。  
   - 在CDM控制台配置源端（Cloudera HBase）和目标端（MRS HBase）连接，建议使用高权限用户（如`omm`）。  

2. **创建迁移作业**  
   - 选择“表/文件迁移”类型，配置源端ZooKeeper地址、目标端HDFS路径（默认`/hbase`），勾选需迁移的表。  
   - 保存作业后启动全量迁移，CDM通过快照导出提升效率，建议在业务低峰期执行。  

#### **二、增量数据同步**  
1. **配置增量任务**  
   - 新建增量迁移作业，设置同步时间段（如`--endtime`参数），仅同步新增数据。  
   - 定期执行增量任务以保持数据一致性，建议结合业务更新频率（如每日）。  

#### **三、数据验证与割接**  
1. **一致性校验**  
   - 通过`count '表名'`或`scan`命令对比源端/目标端记录数，使用MD5校验确保文件完整性。  

2. **业务流量切换**  
   - 逐步将DNS或负载均衡指向MRS集群，分阶段验证查询、写入功能正常。  

3. **源端资源清理**  
   - 删除源端HBase表及关联存储资源（如HDFS目录），释放线下资源。  

#### **四、关键注意事项**  
- **版本兼容性**：源端HBase建议使用2.1.X或1.3.X版本，目标端MRS需支持对应版本。  
- **网络要求**：专线/VPC通道需稳定，大容量迁移建议夜间执行。  
- **权限与配置**：确保源端`hbase.rootdir`路径与目标端一致，避免权限报错。  

通过上述流程，可实现Cloudera HBase到MRS HBase的平滑业务割接。具体操作细节可参考华为云官方网页。
