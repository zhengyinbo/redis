# redis
springboot 集成 redis


```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
</dependency>
```

## @CacheConfig 配置类中会用到的一些共用的缓存配置；

## @Cacheable 表示该方法（类）支持缓存，spring 会在其被调用后将其返回值缓存起来，
## 下次利用同样的参数来执行该方法是可以直接从缓存中获取结果，而不需要再次执行该方法；

| 参数 | 解释 | example |
| --- | --- | --- |
| value | 缓存的名字，在spring配置中定义，必须指定至少一个 | @Cacheable(value="mycache")<br>@Cacheable(value={"cache1","cache2"}) |
| key | 缓存的key，可以为空，可以安装SpEL表达式编写 | @Cacheable(value="testcache",key="#userName") | 
| condition | 缓存的条件，可以为空，布尔值 | @Cacheable(value="testcache",condition="#userName.legth()>2") |


## @Cacheput 
