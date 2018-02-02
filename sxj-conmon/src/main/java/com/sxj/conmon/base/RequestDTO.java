package com.sxj.conmon.base;

import java.io.Serializable;

import lombok.Data;
/**
 * @author SXJ
 * @Date 2017年8月23日
 */
@Data
public class RequestDTO implements Serializable {
	
	private static final long serialVersionUID = -3362115016087146541L;

	private String name;

}
