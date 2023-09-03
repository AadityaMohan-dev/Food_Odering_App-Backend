package com.foodOderingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodOderingApp.model.Vendors;

public interface VendorsRepo extends JpaRepository<Vendors, Long>{
	@Query("select a from Vendors a where a.user.username=?1")
	Vendors findVendorsDetails(String username);

	@Query("select a.airlineCode from Vendors a where a.user.username=?1")
	String gedVendorsCode(String username);
	
	@Query("select a from Vendors a where a.user.id=?1")
	Vendors gedVendorsByUserId(Long id);
}
