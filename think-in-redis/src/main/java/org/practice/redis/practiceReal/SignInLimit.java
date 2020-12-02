package org.practice.redis.practiceReal;

import org.practice.redis.domain.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.time.Duration;

/**
 * @Author :nihongyu
 * @Description: 系统登录次数的限制
 * @Date:Created in 2020/12/2 0002.
 * @Modified By:
 */
@Service
public class SignInLimit {
	static int tempTimesRemain = 0;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;


	public ReturnObject sign(String username, String password) {

		boolean isSign = true;
		int timesRemain = 5;//还可登录的余下次数
		ReturnObject returnObject = new ReturnObject();

		/**
		 * 简略用户名登录查数据库的操作
		 */
		if ("admin".equals(username) && "123456".equals(password)) {
			//实际是数据查询对比的操作
			returnObject.setRespCode("0");
			returnObject.setRespDesc("success");
			returnObject.setRespInfo("登录成功");
			return returnObject;
		} else {
			if (tempTimesRemain == 0) {//第一次登录(如何判定是第一次登录？？，) tempTimesRemain 设置成 static，在类加载的时候就加载，不会变化
				redisTemplate.opsForValue().set("timesRemain", timesRemain);
			}
			tempTimesRemain++;
			long times = redisTemplate.opsForValue().decrement("timesRemain");
			returnObject.setRespCode("1");
			returnObject.setRespDesc("fail");
			returnObject.setRespInfo("登录失败，还有" + times + "次机会");

			if (times == 0) {//锁定，半小时之后才能登录

//				redisTemplate.opsForValue().getOperations().expire("expireTime",);
			}
		}

		return returnObject;
	}


}
