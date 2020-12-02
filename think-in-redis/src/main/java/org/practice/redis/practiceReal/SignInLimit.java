package org.practice.redis.practiceReal;

import org.practice.redis.domain.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

/**
 * @Author :nihongyu
 * @Description: 系统登录次数的限制
 * @Date:Created in 2020/12/2 0002.
 * @Modified By:
 */
@Service
public class SignInLimit {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;


	public ReturnObject sign(String username, String password) {
		int tempTimesRemain = 0;
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
			if (tempTimesRemain == 0) {//第一次登录(如何判定是第一次登录？？)
				redisTemplate.opsForValue().set("timesRemain", timesRemain);
			}
			tempTimesRemain++;
			long times = redisTemplate.opsForValue().decrement("timesRemain");
			returnObject.setRespCode("1");
			returnObject.setRespDesc("fail");
			returnObject.setRespInfo("登录失败，还有" + times + "次机会");
		}

		return returnObject;
	}


}
