package com.onlinebookstore.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.models.Cart;
import com.onlinebookstore.models.Customer;
import com.onlinebookstore.models.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findByCustomer(Customer cust);
	Cart findByCustomerAndProduct(Customer customer,Product product);
	void deleteByCustomer(Customer cust);
}
