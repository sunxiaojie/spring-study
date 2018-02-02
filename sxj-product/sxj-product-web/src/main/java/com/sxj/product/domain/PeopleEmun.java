/**
 * 
 */
package com.sxj.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author SXJ
 * @Date 2017年12月30日
 */
@AllArgsConstructor
@Getter
public enum PeopleEmun {
	
	ADULT(1, "name", "shanghai");
	
	private Integer age;
	
	private String name;
	
	private String address;
	
}
