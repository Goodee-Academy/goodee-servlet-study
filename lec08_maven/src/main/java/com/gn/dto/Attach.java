package com.gn.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attach {
	private int attachNo;
	private int boardNo;
	private String originName;
	private String renewName;
	private String attachRegDate;
}
