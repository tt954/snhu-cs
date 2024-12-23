package contactapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("123456789", "Benji", "Beau", "1234567890", "123 1St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("123456789"));
    }

    @Test
    void testAddContactWithExistingId() {
        Contact contact = new Contact("123456789", "Benji", "Beau", "1234567890", "123 1St");
        contactService.addContact(contact);

        // Should not be able to add a new contact with an existing ID
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("123456789", "Benji", "Beau", "1234567890", "123 1St");
        contactService.addContact(contact);
        contactService.deleteContact("123456789");
        assertNull(contactService.getContact("123456789"));
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Elm St");

        // Contact fields should be updated
        assertEquals("Jane", contactService.getContact("1234567890").getFirstName());
        assertEquals("Smith", contactService.getContact("1234567890").getLastName());
        assertEquals("0987654321", contactService.getContact("1234567890").getPhone());
        assertEquals("456 Elm St", contactService.getContact("1234567890").getAddress());
    }

    @Test
    void testUpdateNotFoundContact() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("nonexistent", "Jack", "Smith", "0987654321", "123 Main St");
        });
        assertEquals("Contact not found", exception.getMessage());
    }
}