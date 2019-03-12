package com.phonebook.dao;

import com.phonebook.entity.Contacts;

import java.util.List;

public interface IContactsDAO {
    List<Contacts> getAllContacts();
    Contacts getContactById(int contactId);
    void addContact(Contacts contact);
    void updateContact(Contacts contact);
    void deleteContact(int contact);
//    boolean contactExists(String name, String number);
}
