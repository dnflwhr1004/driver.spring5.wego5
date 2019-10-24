package com.wego.web.usr;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserMapper {
	
	public void insertUser(User user);
	public User selectByIdPw(User user);
	public int existId(String uid);
	
}
