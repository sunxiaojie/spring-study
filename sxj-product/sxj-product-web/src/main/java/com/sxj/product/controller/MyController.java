package com.sxj.product.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sxj.product.domain.PeopleEmun;
import com.sxj.product.dto.People;


/**
 * @author SXJ
 * @Date 2017年12月16日
 */
@Controller
public class MyController {
	
	@RequestMapping("/test")
	public ModelAndView test(Map<String, Object> map ,HttpServletRequest request, HttpServletResponse response) {
		People people = People.builder()
				.id("1")
				.name("mytest")
				.age("16").build();
		map.put("people", people);
		return new ModelAndView("index", map);
	}

}
