华为云CDM迁移Cloudera Data Platform HBase到华为云MRS HBase的迁移回退触发条件及详细过程
​一、迁移回退触发条件
​数据校验失败
迁移完成后，通过文件数量、大小或哈希值比对发现源端和目标端数据不一致。
HBase表元数据或Region信息校验异常（如hbck命令检测到不一致）。
​业务中断超时
业务切换时间超过预设阈值（如最后一次增量同步时间+切换时间超过业务容忍窗口）。
​版本兼容性问题
源端CDH HBase版本高于目标MRS HBase版本（需确保源端版本 ≤ 目标版本）。
MRS集群版本为2.x及以上时，无法通过HBase修复命令重建表（需使用快照迁移）。
​迁移过程异常
网络中断、CDM任务失败或数据同步中断导致迁移未完成。
迁移后业务功能异常（如查询超时、RegionServer负载过高）。
​二、迁移回退详细过程
​触发回退决策
监控系统或人工验证发现上述触发条件后，立即启动回退流程。
​反向迁移数据（CDM工具）​
​步骤1：在华为云CDM控制台创建反向迁移任务，配置源端（MRS HBase）和目标端（CDH HBase）。
​步骤2：选择需回退的HBase表或数据目录，启动反向同步。
​步骤3：验证反向迁移的数据完整性（如文件数量、大小、哈希值）。
​恢复源端HBase表
​步骤1：若目标端为MRS 1.x版本，通过HBase命令修复表：
bash
hbase hbck -fixMeta <表名>
hbase hbck -fixAssignments <表名>
若存在Region重叠，需额外执行：
bash
hbase hbck -fixHdfsOverlaps <表名>
（参考）
​步骤2：若目标端为MRS 2.x及以上版本，需通过快照恢复：
在源端CDH集群创建HDFS快照（hdfs dfs -createSnapshot）。
使用CDM将快照数据反向迁回源端HBase目录。
​切换业务流量
​步骤1：修改DNS或负载均衡配置，将流量逐步切换回源端CDH集群（参考场景二）。
​步骤2：验证业务功能恢复，监控系统负载和响应时间。
​清理目标端资源
删除MRS集群中已回退的HBase表及关联资源（如OBS存储桶、HDFS目录）。
​三、关键注意事项
​版本兼容性：迁移前需确认源端HBase版本 ≤ 目标MRS版本，避免反向迁移失败。
​数据一致性：反向迁移后需通过hbck命令修复表，并处理可能的Region重叠问题。
​网络稳定性：反向迁移过程中需保持专线或VPC通道畅通，避免中断导致数据不一致。
通过上述流程，可快速实现从MRS HBase到CDH HBase的回退，最大限度降低业务影响。具体操作细节可参考华为云官方网页。




场景二 数据层已经切换到华为云
   1、构建源端数据库数据；
            使用DRS反向迁出RDS；
            使用离线CDM同步OBS增量数据到S3。
   2、停止华为云业务，更改中间件层配置，指向源端数据层数据库；
   3、通过更改DNS配置，逐步切换流量到源端，直到100%；
   4、稳定性观察。



   https://mp.weixin.qq.com/s?__biz=MzkyMDMwMTMwMw==&mid=2247483754&idx=1&sn=1bf6120d1c7ca41960840d75b1aeae64&chksm=c0cd4e376ca2a6c007fc3a1f764c0242c4574fef92d31eddaa31106aabe8dc269c17081cb8a2#rd

   https://support.huaweicloud.com/bestpractice-cdm/cdm_05_0014.html
