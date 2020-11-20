package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
import java.util.List;

@Controller
public class HelloController {

	@Qualifier("bookServiceV1")
	private final BookService bService;
	public HelloController(BookService bService) {
		this.bService = bService;
	}

	@ResponseBody
	@RequestMapping(value="",method=RequestMethod.GET)
	public String Hello() {
		return "Hello Spring-boot Web Application";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("username", "홍길동");
		model.addAttribute("tel","010-111-1111");
		return "home";
	}

	@RequestMapping(value="/car")
	public String car(Model model) {
		BookVO bookVO = BookVO.builder().title("파이리").author("리자드").comp("리자몽").build();
		model.addAttribute("BOOK",bookVO);
		return "book/list_ex";
	}




}
