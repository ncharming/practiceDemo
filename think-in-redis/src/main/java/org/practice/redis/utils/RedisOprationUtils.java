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

	public void sethash() {
		//单独插入一个数据  命令行：hset key filed value
		redisTemplate.opsForHash().put("hash1", "hk1", "hv1");
		redisTemplate.opsForHash().put("hash1", "hk2", "hv2");

		Map map = new HashMap();
		map.put("mhash", "0");
		map.put("mhash1", "1");
		map.put("mhash2", "2");
		//一个key,对应多个value一起插入  命令行：hmset key filed value
		redisTemplate.opsForHash().putAll("hash2", map);
		boolean isExe=redisTemplate.opsForHash().getOperations().hasKey("123456");
        System.out.println("是否存在："+isExe);
	}

	public void gethash(){
        // hget key filed  :获取值
        String v1= (String) redisTemplate.opsForHash().get("hash1", "hk1");
        System.out.println(v1);

        List list=new ArrayList();
        list.add("mhash");
        list.add("mhash1");
        list.add("mhash2");
        //hmget key filed  :获取多个给定的值
        List result=redisTemplate.opsForHash().multiGet("hash2", list);
        for(Object s:result){
            System.out.println(s.toString());
        }

    }

    //类似于 Java LinkedList
    public void setlist(){

        //插入列表头部 lpush key value
	    redisTemplate.opsForList().leftPush("list1","listvalue1");
	    redisTemplate.opsForList().leftPush("list2","listvalue2");

	    List list=new ArrayList();
	    list.add("mul1");
	    list.add("mul2");
	    list.add("mul3");
	    redisTemplate.opsForList().leftPushAll("list3",list);

    }
    public void getlist(){
		//  lpush+lpop=Stack（ 栈）
		//·lpush+rpop=Queue（ 队列）
		//·lpsh+ltrim=Capped Collection（ 有限集合）
		//·lpush+brpop=Message Queue（ 消息队列）
        //取单个list
		redisTemplate.opsForList().rightPop("list2");
		//lrange key start stop  ：start(起始偏移量)、stop(结束位置)     可以用于分页
        List list=redisTemplate.opsForList().range("list3",0,1);
        System.out.println(list);

    }

}
