package dao;

import java.util.List;

import bean.Product;
import exception.ProductException;

public interface ProductService {
	
	boolean addProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(int productId)throws ProductException;
	
	List<Product> getProductsBetweenPrice(int fromPrice, int toPrice)throws ProductException;

}
