package com.gn.common.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptorWrapper extends HttpServletRequestWrapper {

	public PasswordEncryptorWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String param) {
		String result = super.getParameter(param);
		
		return result;
	}
	
	// 단방향 암호화 메서드
	private String getSHA512(String originValue) {
		return null;
	}
}
