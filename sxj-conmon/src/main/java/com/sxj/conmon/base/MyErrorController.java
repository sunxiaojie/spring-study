
package com.sxj.conmon.base;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author SXJ
 * @Date 2017年12月16日
 */
@Controller
public class MyErrorController implements ErrorController {
	
	@GetMapping("error")
	public ModelAndView error(Map<String, Object> model) {
		return new ModelAndView("error/error.html", model);
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		return null;
	}

}
