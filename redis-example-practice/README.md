## redis 数据结构
### 字符串（string）
*   定义：最基本的Redis数据类型。一个键对应一个值，值可以是字符串、整数或浮点数。
*   应用场景：缓存数据、计数器、分布式锁等
*   常用命令
    * `SET key value` ： 设置键和值
    * `GET key` : 获取键的值
    * `INCR key` : 将键的值加1
    *  `DECR key` : 将键的值减1

### 哈希（hash）
### 列表（List）
### 集合（set）
### 有序集合（Sorted Set）
### 位图（Bitmap）
### HyperLogLog
### 地理空间索引（Geospatial）
### 流（Stream）