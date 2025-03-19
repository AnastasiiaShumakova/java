package org.knit.lab24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) throws SQLException {
        if (userDAO.emailExists(email)) {
            throw new IllegalArgumentException("Email уже существует");
        }
        int id = userDAO.findAll().size() + 1;
        while (true) {
            if (userDAO.findById(id) == null) {
                User user = new User(id, name, email);
                userDAO.create(user);
                break;
            }
            else {
                id++;
            }
        }



    }

    public List<User> listAllUsers() throws SQLException {
        List<User> users = userDAO.findAll();
        for (int i = 0; i < (long) users.size(); i++) {
            System.out.println("ID: " + users.get(i).getId() + " Name: " + users.get(i).getName() + " Email: " + users.get(i).getEmail());
        }
        return userDAO.findAll();
    }


    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User existingUser = userDAO.findById(id);
        if (existingUser == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }
        if (!existingUser.getEmail().equals(newEmail) && userDAO.emailExists(newEmail)) {
            throw new IllegalArgumentException("Email уже существует");
        }
        existingUser.setName(newName);
        existingUser.setEmail(newEmail);
        userDAO.update(existingUser);
    }
    
    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }
        userDAO.delete(id);
    }
}

