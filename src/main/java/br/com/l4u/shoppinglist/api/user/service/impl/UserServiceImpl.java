package br.com.l4u.shoppinglist.api.user.service.impl;

import br.com.l4u.shoppinglist.api.user.model.User;
import br.com.l4u.shoppinglist.api.user.repository.UserRepository;
import br.com.l4u.shoppinglist.api.user.service.UserService;
import br.com.l4u.shoppinglist.shared.exceptions.ResourceNotFoundException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    public User searchUserById(String id) {
        return repository.searchById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id #" + id));
    }

    @Override
    public List<User> listAll() {
        return repository.listAll();
    }
}
