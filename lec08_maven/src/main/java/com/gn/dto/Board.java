package com.gn.dto;

import lombok.NoArgsConstructor;

import com.gn.common.vo.Paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board extends Paging {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private String boardRegDate; // 백엔드에서 넣어주는 경우가 없으니 단순 String으로 가져옴 => 자원 절약
	private String boardModDate;
	
	private String keyword;
}
