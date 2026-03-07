package com.addressbook.service;

import com.addressbook.model.AddressBook;
import com.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddressBookService {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public Contact addContact(String bookName, Contact contact) {

        AddressBook book = addressBooks.get(bookName);

        if (book == null) {
            book = new AddressBook(bookName);
            addressBooks.put(bookName, book);
        }

        book.addContact(contact);

        return contact;
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }
}