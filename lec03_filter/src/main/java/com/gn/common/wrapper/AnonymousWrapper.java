package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper {

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String input) {
		String value = super.getParameter(input);
		
		if ("writer".equals(input)) {
			if (value == null || value == "" || !"익명".equals(value)) {
				return "익명";
			}
		}
		
		return value;
	}
}
