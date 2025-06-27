package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Account;

@WebServlet("/searchAccount")
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public SearchAccountServlet() {
    super();
  }

  @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. Servlet에 Account List 목록에서 해당 이름이 존재하는지 확인
		// 이름이 포함된 사람 목록을 보내기
		List<Account> list = new ArrayList<Account>();
		list.add(new Account(1, "김철수"));
		list.add(new Account(2, "이영희"));
		list.add(new Account(3, "홍길동"));
		list.add(new Account(4, "김가남"));
		
		String keyName = request.getParameter("keyName");
		// JSONObject jsonObj = new JSONObject();
		
		JSONArray jsonArr = new JSONArray();
		
		for (Account account : list) {
			// if (account.getName().equals(keyName)) {
			// 	jsonObj.put("no", account.getNo());
			// 	jsonObj.put("name", account.getName());
			// }
			if (account.getName().contains(keyName)) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("no", account.getNo());
				jsonObj.put("name", account.getName());
				jsonArr.add(jsonObj);
			}
		}
		
		// JSON 배열의 경우 Object 상자에 포장해서 보내야 함
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("jsonArr", jsonArr);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonResult);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
