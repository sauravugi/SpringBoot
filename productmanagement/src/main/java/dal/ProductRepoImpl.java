package dal;

import java.util.List;

import org.springframework.stereotype.Repository;

import bean.Product;
import exception.ProductException;

@Repository
public class ProductRepoImpl implements ProductRepo{

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(int productId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsBetweenPrice(int fromPrice, int toPrice) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

}
