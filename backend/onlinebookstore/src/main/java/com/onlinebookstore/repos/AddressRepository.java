package com.onlinebookstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}