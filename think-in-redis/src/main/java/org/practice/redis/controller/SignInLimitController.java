package org.practice.redis.controller;

import org.practice.redis.domain.ReturnObject;
import org.practice.redis.practiceReal.SignInLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @Author :nihongyu
 * @Description:
 * @Date:Created in 2020/12/2 0002.
 * @Modified By:
 */
@RestController
@RequestMapping("/redis")
public class SignInLimitController {

	@Autowired
	private SignInLimit signInLimit;

	@RequestMapping("/sign")
	public Object Sign(@RequestParam("username") String username, @RequestParam("password") String password) {
		ReturnObject returnObject = new ReturnObject();

		returnObject = signInLimit.sign(username, password);

		return returnObject;
	}

}
