package com.foodOderingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Vendors {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String name;
private String vendorCode;
private String email;
private String contact;

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

public String getVendorCode() {
	return vendorCode;
}

public void setVendorCode(String vendorCode) {
	this.vendorCode = vendorCode;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Vendors(Long id, String name, String vendorCode, String email, String contact, User user) {
	super();
	this.id = id;
	this.name = name;
	this.vendorCode = vendorCode;
	this.email = email;
	this.contact = contact;
	this.user = user;
}

public Vendors() {
	super();
	// TODO Auto-generated constructor stub
}

}
