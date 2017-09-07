package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
	
	/** The contact repository. */
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	/** The contact converter. */
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#addContact(com.udemy.backendninja.model.ContactModel)
	 */
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactConverter.convertToEntity(contactModel);
		contactRepository.save(contact);
		return contactConverter.convertToModel(contact);
	}

	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#listContacts()
	 */
	@Override
	public List<ContactModel> listContacts() {
		List<ContactModel> returnData = new ArrayList<ContactModel>();
		List<Contact> contacts = contactRepository.findAll();
		for (Contact contact : contacts) {
			returnData.add(contactConverter.convertToModel(contact));
		}
		return returnData;
	}

	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#findContactById(int)
	 */
	@Override
	public ContactModel findContactById(int id) {
		Contact contact = contactRepository.findById(id);
		if (contact != null) {
			return contactConverter.convertToModel(contact);
		} else {
			return null;
		}
	}

	
	/* (non-Javadoc)
	 * @see com.udemy.backendninja.service.ContactService#removeContact(int)
	 */
	@Override
	public void removeContact(int id) {
		Contact c = contactRepository.findById(id);
		if (c!= null) {
			contactRepository.delete(c);
		}
	}

}
