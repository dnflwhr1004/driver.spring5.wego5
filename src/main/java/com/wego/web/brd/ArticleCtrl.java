package com.wego.web.brd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IConsumer;
import com.wego.web.cmm.ISupplier;
import com.wego.web.pxy.Proxy;
import com.wego.web.pxy.ProxyMap;
import com.wego.web.usr.User;
import com.wego.web.usr.UserCtrl;
import com.wego.web.usr.UserMapper;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Article art;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	@Autowired List<Article>list;
	@Autowired Proxy pxy;
	@Autowired ProxyMap map;
	
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Article param){
		param.setBoardType("게시판");
		IConsumer<Article> c = t->articleMapper.insertArticle(param); 
		c.accept(param);
		ISupplier<String> s =()->articleMapper.countArticle();
		map.accept(Arrays.asList("msg","count"),
				Arrays.asList("SUCCESS",s.get()));
		return map.get();
	}
	
	@GetMapping("/page/{pageNo}/size/{pageSize}")
    public Map<?,?> list(@PathVariable String pageNo,
    		@PathVariable String pageSize){
		System.out.println("넘어 온 페이지 넘버 : " + pageNo);
		pxy.setPageNum(pxy.parseInt(pageNo));
		pxy.setPageSize(pxy.parseInt(pageSize));
		pxy.paging();
        list.clear();    
        ISupplier<List<Article>> s =()->articleMapper.selectAll(pxy);
        printer.accept("해당 페이지 글목록 \n"+s.get());
		map.accept(Arrays.asList("articles","pages"),
				Arrays.asList(s.get(),Arrays.asList(1,2,3,4,5)));
        return map.get();
	}
	
	@GetMapping("/count")
	public Map<?,?> count(){
		ISupplier<String> s =()-> articleMapper.countArticle();
		printer.accept("카운팅 : "+s.get());
		map.accept(Arrays.asList("count"), Arrays.asList(s.get()));
		return map.get();
	}
	
	@GetMapping("/{artseq}")
	public Article read(@PathVariable String artseq, @RequestBody  Article param) {
		return null;
	}
	@PutMapping("/{artseq}")
	public Article update(@PathVariable String artseq, @RequestBody Article param) {
		return null;
	}
	@DeleteMapping("/{artseq}")
	public Map<?,?> delete(@PathVariable String artseq, @RequestBody Article param){
		return null;
	}

}