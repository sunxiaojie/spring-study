package com.sxj.product.controller;

import com.sxj.product.biz.MyBiz;
import com.sxj.product.dto.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;


/**
 * @author SXJ
 * @Date 2017年12月16日
 */
@RestController
//@Validated
public class MyController {

	@Autowired
	private MyBiz myBiz;
	
	@GetMapping("/test")
	public ModelAndView test(Map<String, Object> map ,HttpServletRequest request, HttpServletResponse response) {
		People people = People.builder()
				.id("1")
				.name("mytest")
				.age("16").build();
		map.put("people", people);
		return new ModelAndView("index", map);
	}

	@PostMapping("/testValid")
	public void testValid(@Valid @RequestBody People people) {
		System.out.println("aaaaaaaaaaaaa");
//		People people = People.builder()
//				.id("1")
//				.name("mytest")
//				.age("16").build();
//		map.put("people", people);
//		return new ModelAndView("index", map);
		myBiz.testValid(people.getName());
	}

}
