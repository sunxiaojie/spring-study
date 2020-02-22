package com.sxj.product.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author SXJ
 * @Date 2017年12月16日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class People implements Serializable{

	private static final long serialVersionUID = -6757480416300658912L;

	@NotNull(message = "id can not be null!")
	private String id;
	
	private String name;
	
	private String age;

}
