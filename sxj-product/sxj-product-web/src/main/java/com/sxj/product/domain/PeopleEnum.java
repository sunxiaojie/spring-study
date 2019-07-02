/**
 * 
 */
package com.sxj.product.domain;

import lombok.Getter;

/**
 * @author SXJ
 * @Date 2017年12月30日
 */
@Getter
public enum PeopleEnum {
	
	ADULT(1, "name", "shanghai");
	
	private Integer age;
	
	private String name;
	
	private String address;

	PeopleEnum(Integer age, String name, String address) {
		this.age = age;
		this.name = name;
		this.address = address;
	}
}
