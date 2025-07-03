package com.gn.common.filter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptorWrapper extends HttpServletRequestWrapper {

	public PasswordEncryptorWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String param) {
		String result = super.getParameter(param);
		if (param.contains("memberPw")) {
			result = getSHA512(result);
		}
		
		return result;
	}
	
	// 단방향 암호화 메서드
	private String getSHA512(String originValue) {
		String result = null;
		
		try {
			// 1. Java에서 제공하는 암호화 처리 클래스를 객체화
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			// 2. String 데이터를 byte 배열로 쪼개기
			byte[] originValueBytes = originValue.getBytes();
			
			// 3. 쪼갠 데이터를 암호화 처리
			md.update(originValueBytes);
			
			// 4. 암호화 처리된 값을 byte 배열로 꺼내기
			byte[] encValueBytes = md.digest();
			
			// 5. 꺼낸 값을 String으로 변환
			result = Base64.getEncoder().encodeToString(encValueBytes);
			
		} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
		
		return result;
	}
}
