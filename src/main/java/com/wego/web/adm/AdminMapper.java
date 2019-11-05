package com.wego.web.adm;


import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

	public Admin selectByIdPw(Admin admin);
}
