package com.sxj.conmon.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@RestController
@RequestMapping(value="/common")
public class ConmonController {
	
	@RequestMapping(value="/com", method=RequestMethod.POST)
    public void queryUserInfo() {
		
    }


}
