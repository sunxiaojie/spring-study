
package com.sxj.conmon.base;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SXJ
 * @Date 2017年12月16日
 */
@Controller
public class MyErrorController implements ErrorController {
	
	@RequestMapping("error")
	public ModelAndView error(Map<String, Object> model) {
		return new ModelAndView("error/404", model);
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		return null;
	}

}
