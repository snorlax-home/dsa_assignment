package View;

import java.util.Scanner;

import ADT.ArrayList;
import Controller.UserController;
import Entity.User;

public class UserView {
    private UserController controller;
    private static Scanner sc = new Scanner(System.in);

    public UserView(UserController controller) {
        this.controller = controller;
    }

    public static void printHeader() {
        System.out.println("--------ATLAS Catering--------");
        System.out.println("--------     User     --------");
    }

    private static void printEditScreen(String column) {
        UserView.printHeader();
        System.out.println("You Are Modifying " + column + ":");
        System.out.print("Your New " + column + " : ");
    }

    private static String getRowNumbers(int column) {
        String columnDesc = "";
        switch(column) {
            case 1:
                columnDesc = "Username";
                break;
            case 2:
                columnDesc = "Name";
                break;
            case 3:
                columnDesc = "Email";
                break;
            case 4:
                columnDesc = "Phone Number";
                break;
            case 5:
                columnDesc = "Gender";
                break;
            case 6:
                columnDesc = "Password";
                break;
        }
        return columnDesc;
    }

    private static void printEditScreen(int column) {
        String columnDesc = UserView.getRowNumbers(column);
    
        UserView.printHeader();
        System.out.println("You Are Modifying " + columnDesc + ":");
        System.out.print("Your New " + columnDesc + " is : ");
    }

    public static void printUserMenu() {
        UserView.printHeader();
        System.out.println("1. Show User List");
        System.out.println("2. Edit User");
        System.out.println("3. Delete User");
        System.out.println("4. End Program");
    }

    public static int yourInputChoice(int choicesAmount) {
        System.out.println("----------------------------");
        System.out.print("Your Choice: ");
        int input = InterfaceUtils.getChoice(choicesAmount);
        System.out.println("----------------------------");
        return input;
    }

    public static int yourInputChoice(int choicesAmount, int exception) {
        System.out.println("----------------------------");
        System.out.print("Your Choice: ");
        int input = InterfaceUtils.getChoice(choicesAmount, -1);
        System.out.println("----------------------------");
        return input;
    }

    public static void printUserDetails(User user) {
        System.out.println(user.getUsername() + "'s details:");
        System.out.println("1. Username: " + user.getUsername());
        System.out.println("2. Name: " + user.getName());
        System.out.println("3. Email: " + user.getEmail());
        System.out.println("4. Phone Number:" + user.getPhoneNumber());
        System.out.println("5. Gender: " + user.getGender());
        System.out.println("6. Password: " + user.getPassword());
    }

    public void editUserMenu() {
        // UserView.printEditScreen("Username", user.getUsername());
        // controller.updateUser();
        showUserList();
        System.out.println("Please Input user's number to perform edit and -1 to end the program!");
        int userIndex = UserView.yourInputChoice(controller.usersAmount(), -1);

        if(userIndex != -1) {
            UserView.printUserDetails(controller.readUser(userIndex));
            System.out.println("Please input the number of row to perform edit!");
            int column = UserView.yourInputChoice(6);
            
            UserView.printEditScreen(column);
            String newData = sc.nextLine();
            controller.updateUser(userIndex, UserView.getRowNumbers(column), newData);
        }
    }

    public void deleteUserMenu() {
        showUserList();
        System.out.println("Please Input user's number to perform delete user and -1 to end the program!");
        int userIndex = UserView.yourInputChoice(controller.usersAmount(), -1);
        if(userIndex != -1) {
            controller.deleteUser(userIndex);
        }
    }

    public void showUserList() {
        ArrayList<User> list = controller.readUsers();
        UserView.printHeader();
        ArrayList.printUserHeader();
        for(int i = 1; i <= list.getNumberOfEntries(); i++) {
            System.out.printf("%-10s %-40s \n", i, list.getEntry(i).toString());
        }
    }
    
}
