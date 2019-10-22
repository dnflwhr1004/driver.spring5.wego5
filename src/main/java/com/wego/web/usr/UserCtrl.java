package com.wego.web.usr;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/users")

public class UserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	@Autowired Map<String, Object> map;
	@Autowired User user;
	@Autowired Printer printer;
	
	@PostMapping("/")
	public Map<?, ?> join(@RequestBody User param){
		logger.info("AJAX가 보낸 아이디와 비번{}", param.getUid()+", "+param.getPwd()+","+param.getUname());
		printer.accept("람다 프린터가 출력한 값 : "+param.getUid()+", "+param.getPwd()+","+param.getUname());
		Map<String, Object> map2 = new HashMap<>();
		map2.put("uid", param.getUid());
		map2.put("pwd", param.getPwd());
		map2.put("uname", param.getUname());
		logger.info("map에 담긴아이디와 비번{}", map2.get("uid")+","+map2.get("pwd")+","+map2.get("uname"));
		return map2;
	}
		
	
	@PostMapping("/login")
	public User login(@RequestBody User param){
		logger.info("AJAX 로그인 {}", param.getUid()+", "+param.getPwd()+","+param.getUname());
		user.setUid(param.getUid());
		user.setPwd(param.getPwd());
		user.setUname(param.getUname());
		logger.info("user에 담긴 사용자 정보 {}+", user.toString());
		return user;
	}
	
	
}
