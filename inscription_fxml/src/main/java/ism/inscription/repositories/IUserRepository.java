package ism.inscription.repositories;

import java.util.List;

import ism.inscription.entities.User;

public interface IUserRepository {
    public User findUserByLoginAndPassword(String login, String password);

    public List<User> findAll();

}
