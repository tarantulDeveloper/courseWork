package kg.sklad.services;

import kg.sklad.entities.User;

public interface UserService {
    boolean registerUser (User user);
    String activateUser(String code);

}
