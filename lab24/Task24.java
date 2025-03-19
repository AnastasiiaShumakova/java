package org.knit.lab24;

import java.sql.*;
import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) throws SQLException {

        createTable();

        UserDAOImpl userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);

        boolean running = true;

        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Ввести пользователя: \n");
        System.out.print("2. Изменить пользователя: \n");
        System.out.print("3. Удалить пользователя: \n");
        System.out.print("4. Посмотреть пользователя: \n");
        System.out.print("5. Выход \n");
        while (running) {
            System.out.print("Выберите пункт: \n");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case (1):
                    System.out.print("Введите имя пользователя: \n");
                    String name = scanner.nextLine();
                    System.out.print("Введите email пользователя: \n");
                    String email = scanner.nextLine();
                    userService.registerUser(name, email);
                    break;
                case (2):
                    System.out.print("Введите id пользователя для замены: \n");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите имя пользователя для замены: \n");
                    String newName = scanner.nextLine();
                    System.out.print("Введите email пользователя для замены: \n");
                    String newEmail = scanner.nextLine();
                    userService.updateUser(id, newName, newEmail);
                    break;
                case (3):
                    System.out.print("Введите id пользователя для удаления: \n");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    userService.deleteUser(deleteId);
                    break;
                case (4):
                    System.out.print("Вывод всех пользователей: \n");
                    userService.listAllUsers();
                    break;
                case (5):
                    System.out.println("Программа завершена");
                    running = false;
                    break;
            }
        }
    }

    public static void createTable() throws SQLException {
        String createUsersTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL UNIQUE" +
                ");";

        String insertUsersSQL = "INSERT INTO users (name, email) VALUES\n" +
                "('John Doe', 'john.doe@example.com'),\n" +
                "('Jane Smith', 'jane.smith@example.com'),\n" +
                "('Alice Johnson', 'alice.johnson@example.com'),\n" +
                "('Bob Brown', 'bob.brown@example.com'),\n" +
                "('Charlie White', 'charlie.white@example.com') ON CONFLICT DO NOTHING;";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createUsersTableSQL);

            statement.execute(insertUsersSQL);
        } catch (SQLException e) {
            System.err.println("Ошибка инициализации базы данных: " + e.getMessage());
        }

    }
}

