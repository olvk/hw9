package dao;

import lesson9.User;
import lesson9.UserDetails;

public interface UserDetailsDao {

    public UserDetails createUserDetails(int age, String email);
}
