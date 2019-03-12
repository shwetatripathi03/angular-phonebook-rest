package com.phonebook.service;

import com.phonebook.entity.Contacts;

import java.util.List;

public interface IContactsService {
    List<Contacts> getAllContacts();
    Contacts getContactsById(int contactId);
    void addContacts(Contacts contact);
    void updateContacts(Contacts contact);
    void deleteContact(int contactId);
}
