package com.addressbook.storage;

import com.addressbook.model.Contact;
import java.util.List;

public interface ContactStorage {

    void save(String filePath, List<Contact> contacts);

    List<Contact> load(String filePath);
}