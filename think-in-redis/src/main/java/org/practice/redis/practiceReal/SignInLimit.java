package org.practice.redis.practiceReal;

import org.practice.redis.domain.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @Author :nihongyu
 * @Description: 系统登录次数的限制
 * @Date:Created in 2020/12/2 0002.
 * @Modified By:
 * <p>
 * 登录一个系统，允许5次机会；超过5次则限制登录1小时
 * <p>
 * 用户登录错误次数 key：user:loginCount:fail:用户名
 * 锁定限制登录时间的 key：user:loginTime:lock:用户名
 */
@Service
public class SignInLimit {
	private static long loginCountFail = 5;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;


	public ReturnObject sign(String username, String password) {

		String loginCountFailKey = "user:loginCount:fail:" + username;
		String loginTimeLockKey = "user:loginTime:lock:" + username;

		ReturnObject returnObject = new ReturnObject();

		/**
		 * 简略用户名登录查数据库的操作
		 */
		if ("admin".equals(username) && "123456".equals(password)) {
			//清除登录限制信息
			redisTemplate.delete(loginCountFailKey);
			redisTemplate.delete(loginTimeLockKey);
			//实际是数据查询对比的操作
			returnObject.setRespCode("0");
			returnObject.setRespDesc("success");
			returnObject.setRespInfo("登录成功");
			return returnObject;
		}

		//exists 命令：下面两种判断都可
		boolean isExist_loginTimeLockKey = redisTemplate.hasKey(loginTimeLockKey);
//		boolean isExist_loginTimeLockKey = redisTemplate.opsForValue().getOperations().hasKey(loginTimeLockKey);
		if (isExist_loginTimeLockKey) {//存在限制，则直接返回提示，剩余多长时间可重新登录
//			String lockTime = (String) redisTemplate.opsForValue().get(loginTimeLockKey);
			long lockTime = redisTemplate.opsForValue().getOperations().getExpire(loginTimeLockKey);

			returnObject.setRespCode("0");
			returnObject.setRespDesc("fail");
			returnObject.setRespInfo("登录失败,剩余 " + lockTime/60 + " 分钟可重新登录");
			if(lockTime<=60){
				returnObject.setRespInfo("登录失败,剩余 " + lockTime + " 秒可重新登录");
			}
			return returnObject;
		}

		boolean isExist_loginCountFailKey = redisTemplate.hasKey(loginCountFailKey);
		if (isExist_loginCountFailKey) {//存在
			int is4 = (int) redisTemplate.opsForValue().get(loginCountFailKey);
			if (is4 == 4) {//已经登录了第五次，要进行限制 1h 才能登录
				Duration duration = Duration.ofSeconds(3600);
				redisTemplate.opsForValue().set(loginTimeLockKey, "expireTime");
				redisTemplate.opsForValue().getOperations().expire(loginTimeLockKey, duration);
				returnObject.setRespCode("0");
				returnObject.setRespDesc("fail");
				returnObject.setRespInfo("登录失败，60分钟后可再登录");
				return returnObject;
			} else {
				Long times = redisTemplate.opsForValue().increment(loginCountFailKey);
				returnObject.setRespCode("0");
				returnObject.setRespDesc("fail");
				returnObject.setRespInfo("登录失败，还可登录" + (loginCountFail - times) + "次");
				return returnObject;
			}

		} else {//不存在，是第一次登录失败
			long times = redisTemplate.opsForValue().increment(loginCountFailKey);//设置 loginCountFailKey 并赋值为 1
			returnObject.setRespCode("0");
			returnObject.setRespDesc("fail");
			returnObject.setRespInfo("登录失败，还可登录" + (loginCountFail - times) + "次");
		}

		return returnObject;
	}

}
