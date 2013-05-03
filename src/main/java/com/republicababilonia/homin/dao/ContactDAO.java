package com.republicababilonia.homin.dao;

import java.util.List;

import com.republicababilonia.homin.form.Contact;

public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
