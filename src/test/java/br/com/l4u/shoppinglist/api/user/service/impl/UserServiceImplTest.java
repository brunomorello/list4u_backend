package br.com.l4u.shoppinglist.api.user.service.impl;

import br.com.l4u.shoppinglist.api.user.model.User;
import br.com.l4u.shoppinglist.api.user.repository.utils.UserFakeRepository;
import br.com.l4u.shoppinglist.api.user.service.UserService;
import br.com.l4u.shoppinglist.shared.exceptions.ResourceNotFoundException;
import br.com.l4u.user.Gender;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private static UserService service;

    @BeforeAll
    static void setup() {
        service = new UserServiceImpl(new UserFakeRepository());
    }

    @Test
    void createUser() {
        User user = new User(null, "Fulano", "Ciclano", "Fulano Ciclano", Gender.FEMALE, LocalDate.now());
        service.createUser(user);

        assertNotNull(user.getId(), "Id must not be null");
        assertEquals("Fulano", user.getFirstName(), "First name must be equals");
        assertEquals("Ciclano", user.getLastName(), "Last name must be equals");
        assertEquals("Fulano Ciclano", user.getDisplayName(), "Display name must be equals");
        assertEquals(Gender.FEMALE, user.getGender(), "Gender must be equals");
        assertEquals(LocalDate.now(), user.getBirthday(), "Birthday must be equals");
    }

    @Test
    void updateUser() {
        User user = new User(
                "1",
                "Foot",
                "Test",
                "Footest",
                Gender.MALE,
                LocalDate.now()
        );

        User updatedUser = service.updateUser(user);

        assertEquals("1", updatedUser.getId(), "Id must be equals");
        assertEquals("Foot", updatedUser.getFirstName(), "First name must be equals");
        assertEquals("Test", updatedUser.getLastName(), "Last name must be equals");
        assertEquals("Footest", updatedUser.getDisplayName(), "Display name must be equals");
        assertEquals(Gender.MALE, updatedUser.getGender(), "Gender must be equals");
        assertEquals(LocalDate.now(), updatedUser.getBirthday(), "Birthday must be equals");
    }

    @Test
    void updateUserResourceNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.updateUser(new User(
                    "-10",
                    "Test",
                    "Ciclano",
                    "TestCic",
                    null,
                    null
            ));
        });
    }

    @Test
    void searchUserById() {
        User userFound = service.searchUserById("1");

        assertEquals("1", userFound.getId(), "Id must be equals");
        assertEquals("Foot", userFound.getFirstName(), "First name must be equals");
        assertEquals("Test", userFound.getLastName(), "Last name must be equals");
        assertEquals("Footest", userFound.getDisplayName(), "Display name must be equals");
        assertEquals(Gender.MALE, userFound.getGender(), "Gender must be equals");
        assertEquals(LocalDate.now(), userFound.getBirthday(), "Birthday must be equals");
    }

    @Test
    void searchUserByIdNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> service.searchUserById("-10"));
    }

    @Test
    void listAll() {
        assertNotEquals(0, service.listAll().size(), "List all must not be empty");
    }
}