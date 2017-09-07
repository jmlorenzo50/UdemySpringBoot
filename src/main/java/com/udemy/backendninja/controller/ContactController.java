package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
	
	/** The log. */
	private static Log LOG = LogFactory.getLog(ContactController.class);
	
	/** The contact service. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	/**
	 * Cancel.
	 *
	 * @return the string
	 */
	@GetMapping("/cancel")
	public String cancel() {
		LOG.info("METHOD: cancel");
		return "redirect:/contact/listContacts";
	}
	
	/**
	 * Redirect contact form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	//@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/contactform")
	public String  redirectContactForm(
			@RequestParam(name="id", required=false)int id,
			Model model) {
		LOG.info("METHOD: redirectContactForm");
		
		ContactModel contact = null; 
		if (id > 0) {
			contact = contactService.findContactById(id);
		} else {
			contact = new ContactModel();
		}
		model.addAttribute("contactModel", contact);
		return ViewConstant.CONTANCT_FORM;
	}
	
	
	/**
	 * List contacts.
	 *
	 * @return the model and view
	 */
	@GetMapping("/listContacts")
	public ModelAndView listContacts() {
		LOG.info("METHOD: listContacts");
		ModelAndView mav = new ModelAndView(ViewConstant.CONTANCTS);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("contacts", contactService.listContacts());
		return mav;
	}

	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/addcontact")
	public String addContact(
			@ModelAttribute(name="contactModel") ContactModel contactModel,
			Model model
			){
		LOG.info("METHOD: addContact -- PARAMS: contactModel=" + contactModel);
		if (contactService.addContact(contactModel)!=null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		return "redirect:/contact/listContacts";
	}

	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @return the string
	 */
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel){
		LOG.info("METHOD: addContact -- PARAMS: contactModel=" + contactModel);
		return "redirect:/contact/listContacts";
	}

	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/removeContact")
	public ModelAndView removeContact(
			@RequestParam(name="id", required=true)int id
			) {
		LOG.info("METHOD: removeContact");
		contactService.removeContact(id);
		return listContacts();
	}


}
