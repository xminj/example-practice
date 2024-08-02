## redis 数据结构

### 字符串（string）

* 定义：最基本的Redis数据类型。一个键对应一个值，值可以是字符串、整数或浮点数。
* 应用场景：缓存数据、计数器、分布式锁等
* 常用命令
    * `SET key value` ： 设置键和值
    * `GET key` : 获取键的值
    * `INCR key` : 将键的值加1
    * `DECR key` : 将键的值减1

### 哈希（hash）

* 定义：类似于一个键的集合，一个键对应一个哈希表，哈希表包含多个字段及其值。
* 应用场景：存储对象信息，如用户信息。
* 常用命令
    * `HSET key field value` : 设置哈希表中的字段值
    * `HGET key field` : 获取哈希表中的字段值
    * `HGETALL key`: 获取哈希表中所有字段值

### 列表（List）

* 定义：按顺序存储的字符串，可以在列表的两端进行插入和弹出操作。
* 应用场景：消息队列、任务队列
* 常用命令
    * `LPUSH key value` : 在队列左断插入值
    * `RPUSH key value` : 在列表右端插入值
    * `LPOP key` : 从列表左端获取值
    * `RPOP key` : 从列表右端获取值
    * `LRANGE key start stop`: 获取列表指定范围内的元素

### 集合（set）

* 定义：无序的字符串集合，不允许重复元素。
* 使用场景：标签、用户关注列表、去重等
* 常用命令：
    * `SADD key value` : 向集合添加元素
    * `SREM key value` : 从集合移除元素
    * `SMEMBERS key`: 获取集合中的所有元素
    * `SINTER key1 key2`: 获取两个集合的交集

### 有序集合（Sorted Set）

* 定义：类似于集合，每一个元素关联一个double分数，根据分数进行排序。元素唯一，分数可以重复。
* 使用场景：排行榜、带权重的消息队列
* 常用命令
    * `ZADD key score value` : 向有序集合添加元素及其分数
    * `ZREM key value`: 从有序集合移除元素
    * `ZRANGE key start stop [WITHSCORES]`: 获取有序集合指定范围内的元素
    * `ZRANK key value`: 获取元素排名

### 位图（Bitmap）

* 定义：将一个字符串看作一个位数组，可以对位进行操作
* 使用场景： 用户签到、活跃用户统计
* 常用命令
    * `SETBIT key offset value`: 设置位的值
    * `GETBIT key offset`: 获取位的值
    * `BITCOUNT key [start stop]`: 计算位为1的数量

### HyperLogLog

* 定义：一种用于基数统计的概率性数据结构，可以在固定内存内统计大量不同元素的基数。
* 使用场景：独立访问用户数统计、独立IP数统计。
* 常用命令
    * `PFADD key element`: 向HyperLogLog添加元素
    * `PFCOUNT key`: 返回HyperLogLog的基数估算值

### 地理空间索引（Geospatial）

* 定义：用于存储地址位置信息，并支持基于地理位置的操作。
* 使用场景：定位服务、附近的人和地点
* 常用命令
    * `GEOADD key longitude latitude member`: 添加地理空间位置
    * `GEORADIUS key longitude latitude radius unit`: 获取指定范围内的地理位置
    * `GEODIST key member1 member2 [unit]`: 计算两个位置之间的距离

### 流（Stream）

* 定义：用于存储多条消息的日志数据结构，可以看作一个消息队列
* 使用场景：日志记录、实时消息传递
* 常用命令
    * `XADD key field value`: 向流中添加消息
    * `XRANGE key start end`: 获取指定范围的消息
    * `XREAD COUNT count STREAMS key id`: 读取流中消息