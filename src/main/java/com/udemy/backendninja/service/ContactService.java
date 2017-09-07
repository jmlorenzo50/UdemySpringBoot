package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ContactService {
	
	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact model
	 */
	public abstract ContactModel addContact(ContactModel contactModel);

	/**
	 * List contacts.
	 *
	 * @return the list
	 */
	public abstract List<ContactModel> listContacts();
	
	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	public abstract ContactModel findContactById(int id);
	
	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	public abstract void removeContact(int id);

}
