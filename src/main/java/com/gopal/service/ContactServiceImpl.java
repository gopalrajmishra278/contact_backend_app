package com.gopal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopal.binding.Contact;
import com.gopal.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {
		
		contact= repo.save(contact);  //Insertion
		if(contact.getContactId() != null) {
			
			return "Contact saved";
		}else {
			
			return "Contact failed to save";
		}
		
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return  repo.findAll();
	
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
		Optional<Contact> findById = repo.findById(contactId);
		
        if(findById.isPresent()){
        	
        	return findById.get();
        }
		
		return null;
	}

	
	@Override
	public String updateContact(Contact contact) {
		
		if(repo.existsById(contact.getContactId())) {
			
			repo.save(contact);   //Update operation
			return "Update success";
		}else {
			
			return "No record found";
		}
		
	}

	
	@Override
	public String deleteContactById(Integer contactId) {
		
		if(repo.existsById(contactId)) {
			
			repo.deleteById(contactId);
			return "record deleted";
		}else {
			
			return "No record found";
		}
		
		
	}

}
