package com.sxj.conmon.base;

import java.io.Serializable;

import lombok.Data;
/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@Data
public class ResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1798740756548225213L;
	
	private String code;
	
	private String message;
	
}
