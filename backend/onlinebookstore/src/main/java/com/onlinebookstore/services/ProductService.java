package com.onlinebookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlinebookstore.models.Category;
import com.onlinebookstore.models.Product;
import com.onlinebookstore.repos.ProductRepository;
import com.onlinebookstore.utils.StorageService;

@Service
public class ProductService {

	@Autowired private StorageService storageService;
	@Autowired private ProductRepository dao;
	@Autowired private CategoryService cdao;
	
	public void addProduct(Product b, MultipartFile pic) {
		String photo=storageService.store(pic);
		b.setPhoto(photo);
		dao.save(b);
	}

	public void updateProduct(Product b) {
		dao.save(b);
	}

	public void deleteProduct(int id) {
		dao.deleteById(id);
	}

	public List<Product> allProducts() {
		return dao.findAll();
	}
	
	public List<Product> searchProducts(String search) {
		return dao.findByPnameOrDescrContaining(search,search);
	}

	public Product findProductById(int prodid) {
		return dao.findById(prodid).get();
	}

	public List<Product> categoryProducts(int catid) {
		return dao.findByCategory(cdao.findById(catid));
	}
}


