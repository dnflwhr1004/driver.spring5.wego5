package com.wego.web.usr;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component @Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String uid, pwd,uname,birth,gender,tel,pettype;
}
