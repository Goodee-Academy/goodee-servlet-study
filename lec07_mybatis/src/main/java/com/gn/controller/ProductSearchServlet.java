package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.gn.dto.Product;
import com.gn.service.ProductService;

@WebServlet("/product/search")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service = new ProductService();
       
  public ProductSearchServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전달된 데이터 꺼내오기
		String productName = request.getParameter("productName");
		int productCategory = Integer.parseInt(request.getParameter("productCategory"));
		int sort = Integer.parseInt(request.getParameter("sort"));
		
		// 2. service에 데이터 넘겨주기
		List<Product> productList = service.searchProduct(productName, productCategory, sort);
		System.out.println(productList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
