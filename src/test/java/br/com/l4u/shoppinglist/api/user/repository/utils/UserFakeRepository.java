package br.com.l4u.shoppinglist.api.user.repository.utils;

import br.com.l4u.shoppinglist.api.user.model.User;
import br.com.l4u.shoppinglist.api.user.repository.UserRepository;
import br.com.l4u.shoppinglist.shared.exceptions.ResourceNotFoundException;
import br.com.l4u.user.Gender;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class UserFakeRepository implements UserRepository {

    private List<User> users = new ArrayList<>();
    private Faker faker = new Faker();

    public UserFakeRepository() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        users.add(new User(String.valueOf(faker.number().randomNumber()),
                firstName,
                lastName,
                firstName + " " + lastName,
                Gender.OTHERS,
                LocalDate.of(1992, 8, 14)));

        users.add(new User("1", "Foo", "Bar", "foob", Gender.OTHERS, LocalDate.now()));
    }


    @Override
    public User save(User user) {

        Predicate<User> userIsPresent = u -> Objects.nonNull(u);
        Predicate<User> userHasId = u -> Objects.nonNull(u.getId());
        Predicate<User> userIsPresentAndHasId = userIsPresent.and(userHasId);
        Predicate<User> userIsPresentAndHasNoId = userIsPresent.and(userHasId.negate());

        if (userIsPresentAndHasId.test(user)) {
            searchById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found if id #" + user.getId()));
            users.removeIf(u -> u.getId().equals(user.getId()));
            users.add(user);
        }

        if (userIsPresentAndHasNoId.test(user)) {
            user.setId(String.valueOf(faker.number().randomDigit()));
            users.add(user);
        }

        return user;
    }

    @Override
    public Optional<User> searchById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> listAll() {
        return users;
    }
}
