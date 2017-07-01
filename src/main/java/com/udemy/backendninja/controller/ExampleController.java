package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	private static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@GetMapping("/exampleString") // similar a @RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("name", "Jorge");
		model.addAttribute("person", new Person("person1",23));
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	@GetMapping(value="/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("name", "Mikel");
		mav.addObject("person", new Person("person2",30));
		mav.addObject("people", getPeople());
		return mav; 
	}
	
	
	private List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("person1",10));
		people.add(new Person("person2",20));
		people.add(new Person("person3",30));
		people.add(new Person("person4",40));
		people.add(new Person("person5",50));
		return people;
	}

}
