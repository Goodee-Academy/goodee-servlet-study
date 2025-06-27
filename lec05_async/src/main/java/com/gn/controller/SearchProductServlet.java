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

import com.gn.dto.Product;

@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public SearchProductServlet() {
    super();
  }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "노트북", 1200000));
		productList.add(new Product(1, "스마트폰", 800000));
		productList.add(new Product(2, "물티슈", 3000));
		productList.add(new Product(3, "티셔츠", 25000));
		
		int code = Integer.parseInt(request.getParameter("code"));
		System.out.println(code);
		JSONArray jsonArr = new JSONArray();
		
		for (Product prod : productList) {
			if (code == prod.getCode()) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("name", prod.getName());
				jsonObj.put("price", prod.getPrice());
				
				jsonArr.add(jsonObj);
			}
		}
		
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("jsonArr", jsonArr);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonResult);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
