package com.wego.web.adm;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component @Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	private String eid, pwd, eName,job,mgr,hireDate,sal,cmm,dept;

}
