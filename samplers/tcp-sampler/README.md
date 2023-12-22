MeterSphere 接口测试插件
=============================

从v3.x版本开始支持扩展覆盖整个接口测试的相关插件，涵盖扩展协议，逻辑控制器，前后置操作等。

### 版本说明

插件的版本要求：兼容 JMeter5.6 版本后的所有插件。

### 源码覆盖说明

- `src/main/java`：插件源码 org.apache.jmeter.protocol.tcp.sampler.MsTCPClientImpl.java
- 支持encoding 编码

- 修改原始执行响应内容，支持返回请求参数详细信息

