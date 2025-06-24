package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public PizzaOrderEndServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String pizzaSize = request.getParameter("pizzaSize");
		String[] pizzaTops = request.getParameterValues("pizzaTop");
		String deliveryTime = request.getParameter("deliveryTime");
		
		String pizzaSizeStr = "";
		int pizzaPrice = 0;
		
		switch (pizzaSize) {
			case "1" -> {
				pizzaSizeStr = "Small";
				pizzaPrice = 15900;
			}
			
			case "2" -> {
				pizzaSizeStr = "Medium";
				pizzaPrice = 21000;
			}
			
			case "3" -> {
				pizzaSizeStr = "Large";
				pizzaPrice = 27900;
			}
		}
		
		Map<String, String> topNameMap = new HashMap<String, String>();
		
		topNameMap.put("1", "새우");
		topNameMap.put("2", "고구마");
		topNameMap.put("3", "감자");
		topNameMap.put("4", "파인애플");
		
		if (pizzaTops != null && pizzaTops.length != 0) {
			for (int i = 0; i < pizzaTops.length; i++) {
				pizzaTops[i] = topNameMap.get(pizzaTops[i]);
				
				if ("새우".equals(pizzaTops[i])) pizzaPrice += 2000;
				else pizzaPrice += 1000;
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./views/pizza/result.jsp");
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("pizzaSize", pizzaSizeStr);
		request.setAttribute("pizzaTops", pizzaTops);
		request.setAttribute("pizzaPrice", pizzaPrice);
	
		dispatcher.forward(request, response);
	}

}
