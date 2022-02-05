package br.com.l4u.shoppinglist.api.user.repository;

import br.com.l4u.shoppinglist.api.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User save(User user);
    public Optional<User> searchById(String id);
    public List<User> listAll();
}
