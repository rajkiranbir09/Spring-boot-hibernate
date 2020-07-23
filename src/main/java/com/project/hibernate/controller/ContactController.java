package com.project.hibernate.controller;

import java.util.List;


import com.project.hibernate.entity.Contact;
import com.project.hibernate.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/api/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Contact getContactByID(@PathVariable Integer id) {
        return contactRepository.findByContactId(id);
    }

    @RequestMapping(value = "/searchContacts", method = RequestMethod.GET)
    public Page<Contact> searchContact(
            @RequestParam(name="mc",   defaultValue="")     String mc,
            @RequestParam(name="page", defaultValue="0") 	int page,
            @RequestParam(name="size", defaultValue="5") 	int size) {
        return contactRepository.searchContact("%"+mc+"%", new PageRequest(page, size));
    }

    @PostMapping
    public Contact saveContact(@RequestBody Contact c) {
        return contactRepository.save(c);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteContact(@PathVariable Integer id) {
        contactRepository.delete(this.getContactByID(id));
        return true;
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public Contact updateContact(@PathVariable Integer id, @RequestBody Contact c) {
        c.setContactId(id);
        return contactRepository.save(c);
    }

    public ContactController() {
        // TODO Auto-generated constructor stub
    }

}