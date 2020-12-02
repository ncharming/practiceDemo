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
    public void setstring(){
        redisOprationUtils.setString();
    }
    @RequestMapping("/getstring")
    public void getString(){
        redisOprationUtils.getString();
    }

    @RequestMapping("/sethash")
    public void sethash(){
        redisOprationUtils.sethash();
    }
    @RequestMapping("/gethash")
    public void gethash(){
        redisOprationUtils.gethash();
    }

    @RequestMapping("/setlist")
    public void setlist(){
        redisOprationUtils.setlist();
    }
    @RequestMapping("/getlist")
    public void getlist(){
        redisOprationUtils.getlist();
    }

    @RequestMapping("/setset")
    public void setset(){
        redisOprationUtils.setset();
    }
    @RequestMapping("/getset")
    public void getset(){
        redisOprationUtils.getset();
    }


    @RequestMapping("/setZset")
    public void setZset(){
        redisOprationUtils.setZset();
    }
    @RequestMapping("/getZset")
    public void getZset(){
        redisOprationUtils.getZset();
    }

}
