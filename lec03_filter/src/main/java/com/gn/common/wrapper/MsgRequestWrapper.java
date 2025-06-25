package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class MsgRequestWrapper extends HttpServletRequestWrapper {

	public MsgRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		// return super.getParameter(name);
		
		String value = super.getParameter(name); // 원래 하던 일의 결과를 가져와서
		if ("msg".equals(name) && value != null) {
			return value.replaceAll("shit", "***");
		}
		
		return value;
	}
	
}
