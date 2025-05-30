### 华为云CDM迁移Cloudera HBase到MRS HBase数据校验方案

#### **一、全量数据校验**
1. **源端MD5校验**  
   - 在CDM源端作业参数中配置`MD5文件名后缀`（如`.md5`），CDM仅迁移与源文件MD5值匹配的数据文件，未匹配或无MD5文件的文件迁移失败。  
   - 支持HDFS、OBS等源端文件系统的MD5校验。  

2. **目标端MD5校验**  
   - 迁移至OBS时，CDM通过HTTP Header将写入文件的MD5值传递给OBS，OBS校验后返回结果至指定校验桶，确保目标端数据与源端一致。  

#### **二、增量数据校验**  
- 增量迁移任务默认继承源端配置，同步过程中自动校验新增数据的MD5值，确保与源端实时一致。  

#### **三、关键注意事项**  
- **校验与加密冲突**：使用MD5校验时，目标端OBS不可启用KMS加密。  
- **网络稳定性**：校验过程依赖网络传输，建议专线/VPC通道保持高可用。  

通过上述方案，可实现Cloudera HBase到MRS HBase迁移过程中数据完整性的双重保障。具体操作参数可参考华为云官方网页。
