package com.company.view;

import com.company.model.User;
import com.company.service.UserService;
import com.company.servicedb.UserServiceDatabase;

import java.util.List;
import java.util.Scanner;

public class UserView {

    public void showInterface(boolean db) {
        boolean userFlag = true;
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        UserServiceDatabase userServiceDatabase = new UserServiceDatabase();

        while(userFlag) {
            System.out.println("User options: ");
            System.out.println("1. Get all users");
            System.out.println("2. Delete all users");
            System.out.println("3. Create new user");
            System.out.println("4. Get user by ID");
            System.out.println("5. Update user by ID");
            System.out.println("6. Delete user by ID");
            System.out.println("0. Exit");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    List<User> users;
                    if(db) {
                        users = userServiceDatabase.getAll();
                    } else {
                        users = userService.getAll();
                    }
                    for(User iter : users) {
                        System.out.println(iter.toString());
                    }
                    break;
                case "2":

                    if(db) {
                        // Implement db!!!
                    } else {
                        userService.deleteAll();
                    }
                    break;
                case "3":
                    System.out.println("Enter new user's information");
                    System.out.println("Login: ");
                    String login = scanner.nextLine();
                    System.out.println("Password: ");
                    String password = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    System.out.println("Role: ");
                    String role = scanner.nextLine();
                    if(db) {
                        userServiceDatabase.createUser(login, password, email, role);
                    } else {
                        userService.createUser(login, password, email, role);
                    }
                    break;
                case "4":
                    System.out.println("Enter ID: ");
                    String id = scanner.nextLine();
                    User tempUser;
                    if(db) {
                        tempUser = userServiceDatabase.getByID(id);
                    } else {
                        tempUser = userService.getByID(id);
                    }
                    if(tempUser != null) {
                        System.out.println(tempUser.toString());
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case "5":
                    System.out.println("Enter needed user's ID: ");
                    id = scanner.nextLine();
                    System.out.println("Enter new user information");
                    System.out.println("Login: ");
                    login = scanner.nextLine();
                    System.out.println("Password: ");
                    password = scanner.nextLine();
                    System.out.println("Email: ");
                    email = scanner.nextLine();
                    System.out.println("Role: ");
                    role = scanner.nextLine();
                    if(db) {
                        userServiceDatabase.updateByID(id, login, password, email, role);
                    } else {
                        userService.updateByID(id, login, password, email, role);
                    }
                    break;
                case "6":
                    System.out.println("Enter needed user's ID: ");
                    id = scanner.nextLine();
                    if(db) {
                        userServiceDatabase.deleteByID(id);
                    } else {
                        userService.deleteByID(id);
                    }
                    break;
                default:
                    userFlag = false;
                    break;
            }
        }
    }
}
