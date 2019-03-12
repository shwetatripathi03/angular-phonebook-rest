package com.phonebook.service;

import com.phonebook.dao.IContactsDAO;
import com.phonebook.entity.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService implements IContactsService {
    @Autowired
    private IContactsDAO contactsDAO;
    @Override
    public Contacts getContactsById(int articleId) {
        Contacts cont = contactsDAO.getContactById(articleId);
        return cont;
    }
    @Override
    public List<Contacts> getAllContacts(){
        return contactsDAO.getAllContacts();
    }
    @Override
    public void addContacts(Contacts contact){
        contactsDAO.addContact(contact);
    }
    @Override
    public void updateContacts(Contacts contact) {
        contactsDAO.updateContact(contact);
    }
    @Override
    public void deleteContact(int contactId) {
        contactsDAO.deleteContact(contactId);
    }
}
