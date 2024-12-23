package contactapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    private final String mockContactId = "123456789";
    private final String mockFirstName = "Monchhichi";
    private final String mockLastName = "Angel";
    private final String mockPhone = "1234567890";
    private final String mockAddress = "Dixon Landing Dr";

    @Test
    public void testValidContactConstructor() {
        Contact contact = new Contact(mockContactId, mockFirstName, mockLastName, mockPhone, mockAddress);

        assertEquals(mockContactId, contact.getContactId());
        assertEquals(mockFirstName, contact.getFirstName());
        assertEquals(mockLastName, contact.getLastName());
        assertEquals(mockPhone, contact.getPhone());
        assertEquals(mockAddress, contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        // Null contact id
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, mockFirstName, mockLastName, mockPhone, mockAddress);
        });
        // Contact id longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", mockFirstName, mockLastName, mockPhone, mockAddress);
        });
    }

    @Test
    public void testInvalidFirstName() {
        // Null first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, null, mockLastName, mockPhone, mockAddress);
        });
        // First name longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, "LongFirstName", mockLastName, mockPhone, mockAddress);
        });
    }

    @Test
    public void testInvalidLastName() {
        // Null last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, null, mockPhone, mockAddress);
        });
        // Last name longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, "LongLastName", mockPhone, mockAddress);
        });
    }

    @Test
    public void testInvalidPhone() {
        // Null phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, mockLastName, null, mockAddress);
        });
        // Phone number shorter than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, mockLastName, "1234", mockAddress);
        });
        // Phone number longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, mockLastName, "12345678901", mockAddress);
        });
        // Alphanumerical phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, mockLastName, "inval1dNum", mockAddress);
        });
    }

    @Test
    public void testInvalidAddress() {
        // Null address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, mockLastName, mockPhone, null);
        });
        // Address longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(mockContactId, mockFirstName, mockLastName, mockPhone, "This address is quite long, longer than 30 characters");
        });
    }
}