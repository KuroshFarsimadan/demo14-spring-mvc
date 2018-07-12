/**
 * 
 */
package ir.kuroshfarsimadan.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ir.kuroshfarsimadan.bean.Person;
import ir.kuroshfarsimadan.bean.PersonImpl;
import ir.kuroshfarsimadan.dao.PersonDAO;

/**
 * @author User
 *
 */
@Controller
/*
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.
 * html The @RequestMapping annotation is used to map requests to controllers
 * methods. It has various attributes to match by URL, HTTP method, request
 * parameters, headers, and media types. It can be used at the class-level to
 * express shared mappings or at the method level to narrow down to a specific
 * endpoint mapping.
 * 
 * There are also HTTP method specific shortcut variants of @RequestMapping:
 * 
 * @GetMapping
 * 
 * @PostMapping
 * 
 * @PutMapping
 * 
 * @DeleteMapping
 * 
 * @PatchMapping
 */
@RequestMapping(value = "/persons")
public class PersonController {

	@Inject
	private PersonDAO dao;

	public PersonDAO getDao() {
		return dao;
	}

	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}

	// When we want to create / show the form (GET)
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Person emptyPerson = new PersonImpl();
		emptyPerson.setFirstname("defaultName");
		model.addAttribute("person", emptyPerson);
		return "person/createForm";
	}

	/*
	 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.
	 * html Use the @ModelAttribute annotation on a method argument to access an
	 * attribute from the model, or have it instantiated if not present. The model
	 * attribute is also overlaid with values from HTTP Servlet request parameters
	 * whose names match to field names. This is referred to as data binding and it
	 * saves you from having to deal with parsing and converting individual query
	 * parameters and form fields.
	 */
	// When we want to save the form data (POST)
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String create(@ModelAttribute(value = "person") PersonImpl person) {
		dao.save(person);
		return "redirect:/persons/" + person.getId();
	}

	// When we want to show a particular persons details. You can also declare URI
	// variables and access their values with @PathVariable
	// (https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-requestmapping-uri-templates)
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Integer id, Model model) {
		Person person = dao.find(id);
		model.addAttribute("person", person);
		return "person/view";
	}

}
