package dao;

import lesson9.User;

public interface UserDao {

    User createUser(String login, String name, String lastName);

}
