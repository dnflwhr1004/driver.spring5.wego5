//package com.wego.web.aop;
//
//import java.util.HashMap;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.wego.web.utl.Printer;
//
//@RestController
//@Transactional
//@RequestMapping("/crawl")
//public class TxController {
//	@Autowired Printer p;
//	@Autowired TxService txService;
//	@Autowired HashMap<String,String> map;
//	
//	@GetMapping("/crawling/{site}/{srch}")
//	public void bringurl(@PathVariable String site,
//			@PathVariable String srch) {
//		p.accept(site +", srch "+srch);
//		map.clear();
//		map.put("site", site);
//		map.put("srch", srch);
//		txService.crawling(map);
//	}
//	
//}
