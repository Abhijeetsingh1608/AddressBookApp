package com.addressbook;

import com.addressbook.model.Contact;
import org.junit.jupiter.api.Test;

import com.addressbook.Contact;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void givenValidContactDetails_whenObjectCreated_shouldReturnCorrectValues() {

        Contact contact = new Contact(
                "Abhijeet",
                "Prabhat",
                "New City",
                "Ariana",
                "Geornite",
                "567834",
                "7634237809",
                "tp@gmail.com"
        );

        assertEquals("Abhijeet", contact.getFirstName());
        assertEquals("Prabhat", contact.getLastName());
        assertEquals("Ariana", contact.getCity());
        assertEquals("Geornite", contact.getState());
        assertEquals("7634237809", contact.getPhoneNumber());
    }


    @Test
    public void givenEmptyConstructor_whenSettersUsed_shouldReturnCorrectValues() {

        Contact contact = new Contact();

        contact.setFirstName("John");
        contact.setLastName("Doe");
        contact.setCity("Delhi");

        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("Delhi", contact.getCity());
    }


    @Test
    public void givenTwoContactsWithSameName_whenCompared_shouldReturnEqual() {

        Contact c1 = new Contact(
                "AP", "Sharma",
                "Addr1", "City1", "State1",
                "111111", "9999999999", "a@mail.com"
        );

        Contact c2 = new Contact(
                "AP", "Sharma",
                "Addr2", "City2", "State2",
                "222222", "8888888888", "b@mail.com"
        );

        assertEquals(c1, c2);
    }


    @Test
    public void givenTwoContactsWithDifferentNames_whenCompared_shouldReturnNotEqual() {

        Contact c1 = new Contact("AP", "Sharma", "", "", "", "", "", "");
        Contact c2 = new Contact("Rahul", "Verma", "", "", "", "", "", "");

        assertNotEquals(c1, c2);
    }


    @Test
    public void givenSameContactObjects_whenHashCodeCalled_shouldReturnSameHash() {

        Contact c1 = new Contact("AP", "Sharma", "", "", "", "", "", "");
        Contact c2 = new Contact("AP", "Sharma", "", "", "", "", "", "");

        assertEquals(c1.hashCode(), c2.hashCode());
    }


    @Test
    public void givenContactWithNullValues_shouldHandleGracefully() {

        Contact contact = new Contact();

        assertNull(contact.getFirstName());
        assertNull(contact.getLastName());
        assertNull(contact.getCity());
    }


    @Test
    public void givenContact_whenUpdatingPhoneNumber_shouldReturnUpdatedValue() {

        Contact contact = new Contact();

        contact.setPhoneNumber("1111111111");
        contact.setPhoneNumber("9999999999");

        assertEquals("9999999999", contact.getPhoneNumber());
    }


    @Test
    public void givenContact_whenUpdatingEmail_shouldReturnUpdatedEmail() {

        Contact contact = new Contact();

        contact.setEmail("old@mail.com");
        contact.setEmail("new@mail.com");

        assertEquals("new@mail.com", contact.getEmail());
    }

}