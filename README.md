# eshop
This project is monitoring real situation e-commercial company back-end project.
Please don't use the code on commercial purpose.
You have my thanks.


一、迁移前备份策略
​全量备份
使用HBase自带工具导出表数据至HDFS或本地存储：
bash
hbase org.apache.hadoop.hbase.mapreduce.Export '表名' /备份路径
备份文件需存储在安全位置（如华为云OBS或HDFS）。
​华为云MRS补充：通过FusionInsight Manager创建全量备份任务，确保备份路径与目标集群兼容。
​增量备份
定期使用hbase backup create incremental创建增量备份，减少回退数据量。
​华为云MRS补充：启用跨集群拷贝功能，实时同步增量数据至原集群备用。
​元数据备份
导出HBase配置文件（hbase-site.xml、.META.表结构）及集群拓扑信息。

数据不一致或业务异常（如写入失败、查询错误）。
迁移后性能未达预期或存在兼容性问题。
完全回退需求（如需恢复至迁移前状态）
