package com.foodOderingApp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class EatNFun {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name = "EatNFun";
	private String contact = "8881*******";
	private String email = "aadimohan51@gmail.com";
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "App_id", referencedColumnName = "id")
	private List<Vendors> vendor;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "App_id", referencedColumnName = "id")
	private List<Customer> customer;
	
	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Vendors> getVendor() {
		return vendor;
	}

	public void setVendor(List<Vendors> vendor) {
		this.vendor = vendor;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EatNFun(Long id, String name, String contact, String email, List<Vendors> vendor, List<Customer> customer,
			com.foodOderingApp.model.User user) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.vendor = vendor;
		this.customer = customer;
		this.user = user;
	}

	public EatNFun() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
