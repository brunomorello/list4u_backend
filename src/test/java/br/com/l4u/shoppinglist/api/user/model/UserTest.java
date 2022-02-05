package br.com.l4u.shoppinglist.api.user.model;

import br.com.l4u.user.Gender;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private Faker faker = new Faker();

    @Test
    void testUserGetters() {
        String firstName = "Bruno";
        String lastName = "Moreno";
        String displayName = firstName + " Oliveira " + lastName;

        user = new User(
                String.valueOf(faker.number().randomNumber()),
                firstName,
                lastName,
                displayName,
                Gender.MALE,
                LocalDate.of(1992, 8, 14)
        );

        assertNotNull(user.getId(), "ID Must not be equals");
        assertEquals("Bruno", user.getFirstName(), "Name must be equals");
        assertEquals("Moreno", user.getLastName(), "Last name must be equals");
        assertEquals("Bruno Oliveira Moreno", user.getDisplayName(), "Display Name must be equals");
        assertEquals(Gender.MALE, user.getGender(), "Gender must be equals");
        assertEquals(LocalDate.of(1992, 8, 14), user.getBirthday(), "Birthday must be equals");
    }

    @Test
    void testUserSetter() {
        user = new User();
        user.setId("123");
        user.setFirstName("Foo");
        user.setLastName("Bar");
        user.setDisplayName("Foob");
        user.setGender(Gender.OTHERS);
        user.setBirthday(LocalDate.of(1996, 1, 10));

        assertEquals("123", user.getId(), "ID must be equals");
        assertEquals("Foo", user.getFirstName(), "First name must be equals");
        assertEquals("Bar", user.getLastName(), "Last name must be equals");
        assertEquals("Foob", user.getDisplayName(), "Display name must be equals");
        assertEquals(Gender.OTHERS, user.getGender(), "Gender must be equals");
        assertEquals(LocalDate.of(1996, 1, 10), user.getBirthday(), "Birthday must be equals");
    }
}