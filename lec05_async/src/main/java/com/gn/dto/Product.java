package com.gn.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
	private int code;
	private String name;
	private int price;
}
