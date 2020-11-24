package org.practice.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Classname RedisOprationUtils
 * @Description TODO
 * @Date 2020/11/23
 * @Created by charming
 */
@Configuration
public class RedisOprationUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setString() {
        redisTemplate.opsForValue().set("str1", "strValue1");
        redisTemplate.opsForValue().set("str2", "strValue2");
        //只有key不存在时才会设置，否则不做操作：底层命令是 setnx(k,v)
        redisTemplate.opsForValue().setIfAbsent("str1", "strV1");
        //重新给一个key赋值，key不存在返回 nil;底层命令是 getset
        redisTemplate.opsForValue().getAndSet("str2", "strV2");

        //将 key 中存储的数字值增 1 ，如果 key 不存在，那么 key 的值会先被初始化为 0，然后再执行 INCR 操作；decr 同理
        redisTemplate.opsForValue().increment("str3");

        //设置过期时间
        redisTemplate.opsForValue().set("exTime", "timeValue", Duration.ofMinutes(2));

        Map<String, Object> map = new HashMap();
        for (int i = 0; i < 3; i++) {
            map.put("mul" + i, "mulValue" + i);
        }
        redisTemplate.opsForValue().multiSet(map);//多个多个插入：底层命令 mset

        System.out.println("插入操作完成");
    }

    public void getString() {
        List<Object> listResult = new ArrayList<>();
        Set<String> set = redisTemplate.keys("*");
        System.out.println("所有的键：" + set);
        listResult = redisTemplate.opsForValue().multiGet(set);
        System.out.println("所有的值：" + listResult);

        Long l1 = redisTemplate.opsForValue().getOperations().getExpire("exTime");//显示的是秒
        System.out.println("过期剩余时间：" + l1);

    }

}
