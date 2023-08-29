package com.gopal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopal.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	

}
