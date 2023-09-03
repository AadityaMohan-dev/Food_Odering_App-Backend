package com.foodOderingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodOderingApp.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{
	@Query("select a from Customer a where a.user.username=?1")
	Customer findACustomerDetails(String username);

	@Query("select a.airlineCode from Customer a where a.user.username=?1")
	String getACustomerCode(String username);
	
	@Query("select a from Customer a where a.user.id=?1")
	Customer getCustomerByUserId(Long id);

}
