package br.com.l4u.shoppinglist.api.user.service;

import br.com.l4u.shoppinglist.api.user.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User updateUser(User user);
    public User searchUserById(String id);
    public List<User> listAll();
}
