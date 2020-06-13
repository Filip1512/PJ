package repositories;

import datebase.Connect;
import domain.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyRegistrationRepository implements RegistrationRepository{

    @Override
    public Users getRegistrationByLogin (String username) {
        Users user = null;
        Connect con = new Connect();
        Connection connection = con.getGonnection();
        System.out.println("Connected!");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT username, email, isAdmin, isPremium FROM users where username = ? LIMIT 1");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next())
            {
                user = new Users();
                user.setUsername(result.getString("username"));
                user.setEmail(result.getString("email"));
                user.setAdmin(result.getBoolean("isAdmin"));
                user.setPremium(result.getBoolean("isPremium"));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Boolean checkPassword(String username, String password) {
        Boolean correctPassword = false;

        Connect con = new Connect();
        Connection connection = con.getGonnection();
        System.out.println("Connected!");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT username, email, isAdmin, isPremium FROM users where username = ? AND password = ? LIMIT 1");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                correctPassword = true;
            }
            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return correctPassword;
    }

    @Override
    public List<Users> getAllUsersData() {
        List<Users> userList = new ArrayList<Users>();

        Connect con = new Connect();
        Connection connection = con.getGonnection();
        System.out.println("Connected!");

        try {
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT username, email, isAdmin, isPremium FROM users");

            while (result.next()) {
                Users user = new Users();
                user.setUsername(result.getString("usename"));
                user.setEmail(result.getString("email"));
                user.setAdmin(result.getBoolean("isAdmin"));
                user.setPremium(result.getBoolean("isPremium"));
                userList.add(user);
            }
            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void add(Users user) {
        Connect con = new Connect();
        Connection connection = con.getGonnection();
        System.out.println("Connected!");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, email, isAdmin, isPremium) VALUES (?,?,?,false,false)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePremiumStatus(String[] userList, String[] checkedList) throws SQLException {
        Connect con = new Connect();
        Connection connection = con.getGonnection();
        System.out.println("Connected!");

        for (String username : userList) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET isPremium = ? WHERE username = ?");
                preparedStatement.setBoolean(1, Arrays.asList(checkedList).contains(username));
                preparedStatement.setString(2, username);
                preparedStatement.executeUpdate();

            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        connection.close();
    }

}
