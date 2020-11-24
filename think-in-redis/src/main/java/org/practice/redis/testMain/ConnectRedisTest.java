package org.practice.redis.testMain;

import redis.clients.jedis.Jedis;

/**
 * @Classname ConnectRedisTest
 * @Description TODO 在虚拟机中安装了redis，本地测试连接 https://blog.csdn.net/weixin_41793772/category_9818581.html
 * @Date 2020/11/23
 * @Created by charming
 */
public class ConnectRedisTest {
    public static void main(String[] args) {
        String ip = "192.168.177.129";//虚拟机的IP地址
        int port = 6379;
        Jedis jedis = new Jedis(ip, port);
        jedis.auth("123456");
        //打印 PONG ,说明已经链接成功
        System.out.println(jedis.ping());

        //string
        String str = jedis.get("nhy");
        System.out.println(str);

        //hash
        String hstr = jedis.hget("ncharming", "charming");
        System.out.println(hstr);
    }
}
