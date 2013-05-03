package com.republicababilonia.homin.service;

import java.util.List;

import com.republicababilonia.homin.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
