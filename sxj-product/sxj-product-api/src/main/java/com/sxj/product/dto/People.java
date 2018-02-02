package com.sxj.product.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SXJ
 * @Date 2017年12月16日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class People implements Serializable{

	private static final long serialVersionUID = -6757480416300658912L;
	
	private String id;
	
	private String name;
	
	private String age;

}
