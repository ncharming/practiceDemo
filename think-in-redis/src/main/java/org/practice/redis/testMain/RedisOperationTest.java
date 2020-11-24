package org.practice.redis.testMain;

import org.practice.redis.utils.RedisOprationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RedisOperationTest
 * @Description TODO
 * @Date 2020/11/23
 * @Created by charming
 */
@RestController
@RequestMapping("/redis")
public class RedisOperationTest {

    @Autowired
    private RedisOprationUtils redisOprationUtils;

    @RequestMapping("/setstring")
    public void testController(){
        redisOprationUtils.setString();
    }
    @RequestMapping("/getstring")
    public void getString(){
        redisOprationUtils.getString();
    }



}
