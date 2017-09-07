package com.udemy.backendninja.component;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {
	
	/**
	 * Convert to entity.
	 *
	 * @param contactModel the contact model
	 * @return the contact
	 */
	public Contact convertToEntity(ContactModel contactModel){
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setCity(contactModel.getCity());
		contact.setTelephone(contactModel.getTelephone());
		return contact;
	}


	/**
	 * Convert to model.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public ContactModel convertToModel(Contact contact){
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setCity(contact.getCity());
		contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}


}
