package com.addressbook.util;

import com.addressbook.model.Contact;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static void writeContactsToCSV(String filePath, List<Contact> contacts) {
        try {
            File file = new File(filePath);
            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
                for (Contact contact : contacts) {
                    String[] data = {
                            contact.getFirstName() == null ? "" : contact.getFirstName(),
                            contact.getLastName() == null ? "" : contact.getLastName(),
                            contact.getCity() == null ? "" : contact.getCity(),
                            contact.getState() == null ? "" : contact.getState(),
                            contact.getZip() == null ? "" : contact.getZip()
                    };

                    writer.writeNext(data);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("CSV write error", e);
        }
    }

    public static List<Contact> readContactsFromCSV(String filePath) {
        List<Contact> contacts = new ArrayList<>();

        try {
            File file = new File(filePath);

            if (!file.exists()) {
                return contacts;
            }

            try (CSVReader reader = new CSVReader(new FileReader(file))) {
                String[] data;

                while ((data = reader.readNext()) != null) {

                    if (data.length == 0) {
                        continue;
                    }

                    if (data[0] == null || data[0].trim().isEmpty()) {
                        continue;
                    }

                    if (data.length < 5) {
                        continue;
                    }

                    Contact contact = new Contact(
                            data[0], // firstName
                            data[1], // lastName
                            "",      // address
                            data[2], // city
                            data[3], // state
                            data[4], // zip
                            "",      // phoneNumber
                            ""       // email
                    );

                    contacts.add(contact);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("CSV read error", e);
        }

        return contacts;
    }
}