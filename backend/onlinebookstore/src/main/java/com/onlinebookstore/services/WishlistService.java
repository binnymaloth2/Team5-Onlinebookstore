package com.onlinebookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dtos.WishlistDTO;
import com.onlinebookstore.models.Customer;
import com.onlinebookstore.models.Product;
import com.onlinebookstore.models.Wishlist;
import com.onlinebookstore.repos.WishlistRepository;

@Service
public class WishlistService {

	@Autowired private WishlistRepository repo;
	@Autowired private CustomerService cservice;
	
	public void save(WishlistDTO dto) {
		Wishlist wl=new Wishlist();
		wl.setProduct(dto.getProduct());
		wl.setCustomer(cservice.findById(dto.getCustid()));
		repo.save(wl);
	}
	
	public List<Wishlist> findByuserid(int id){
		return repo.findByCustomer(cservice.findById(id));
	}
	
	public void deleteItem(int id) {
		repo.deleteById(id);
	}
	
	public boolean checkexist(int custid,Product product) {
		return repo.findByCustomerAndProduct(cservice.findById(custid), product)!=null;
	}
}



