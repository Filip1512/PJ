package repositories;

import java.sql.SQLException;
import java.util.List;

import domain.Users;

public interface RegistrationRepository {
    Users getRegistrationByLogin (String username);
    Boolean checkPassword (String username, String password);
    List<Users> getAllUsersData();

    void add(Users registration);
    void updatePremiumStatus (String[] userList, String[] checkedList) throws SQLException;
}