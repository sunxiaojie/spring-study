package com.sxj.conmon.util;

import lombok.Getter;
import lombok.Setter;
/**
 * @author SXJ
 * @Date 2017年8月23日
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 5588785682860345447L;
	
	@Setter
	@Getter
	private String code;
	
	@Getter
	@Setter
	private String message;
	
	public ApplicationException(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
