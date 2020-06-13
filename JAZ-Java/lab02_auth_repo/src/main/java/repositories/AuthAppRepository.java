package repositories;

import domain.AuthApp;

public interface AuthAppRepository {
    AuthApp getUserByLogin (String username);
    //Boolean checkPassword (String username, String password);
    //List<Users> getAllUsersData();
    void add(AuthApp user);
    void updatePremiumStatus (String[] userList, String[] checkedList);
}