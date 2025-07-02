package com.gn.service;

import java.util.List;

import com.gn.dao.ProductDao;
import com.gn.dto.Product;

public class ProductService {
	private ProductDao dao = new ProductDao();
	
	public List<Product> searchProduct(String productName, int productCategory, int sort) {
		Product product = new Product();
		product.setProductName(productName);
		product.setProductCategory(productCategory);
		product.setSort(sort);
		
		return dao.searchProduct(product);
	}
}
