package com.wego.web.adm;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wego.web.cmm.IFunction;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/admins")
public class AdminCtrl {
	@Autowired Map<String, Object>map;
	@Autowired Admin admin;
	@Autowired Printer printer;
	@Autowired AdminMapper adminMapper;
	
	
	@PostMapping("/{eid}")
    public Map<?,?> login(@PathVariable String eid , @RequestBody Admin param) {
		printer.accept("login들어옴+");
		IFunction<Admin,Admin> f = t -> adminMapper.selectByIdPw(param);
		map.clear();
		map.put("msg", (f.apply(param))!=null?"SUCCESS":"fail");
       return map;
    }
	
	
	
}
