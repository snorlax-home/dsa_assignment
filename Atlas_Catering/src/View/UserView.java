package test;

import View.InterfaceUtils;
import java.util.Scanner;

import ADT.ArrayList;

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

    private static void printEditScreen(String column, String prevData) {
        UserView.printHeader();
        System.out.println("You Are Modifying " + column + ":");
        System.out.println("Your Previous " + column + " : " + prevData);
        System.out.print("Your New " + column + " : ");
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

    public static void printUserDetails(User user) {
        System.out.println(user.getName() + "'s details:");
        System.out.println("Username: " + user.getUsername());
    }

    public void editUsername() {
        // UserView.printEditScreen("Username", user.getUsername());
        // controller.updateUser();
        showUserList();
        System.out.println("Please Input user's number to perform edit and -1 to end the program!");
        int action = UserView.yourInputChoice(2);
        switch(action) {
            case 1:

                

                break;
            case 2:

                break;
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

    public static void main(String[] args) {
        UserController controller = new UserController();
        UserView view = new UserView(controller);     
        

        int choices = 4;

        
        User tengli = new User("Tengli", "Shiyoruxz");
        controller.createUser(tengli);
        
        while(controller.programRunning()) {
            UserView.printUserMenu();
            int input = UserView.yourInputChoice(choices);
            switch(input) {
                case 1:
                    view.showUserList();
                    InterfaceUtils.continuePrompt();
                    break;
                case 2:
                    view.editUsername();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Thank you for using Atlas Catering!");
                    controller.endProgram();
                    break;
            }
        }
        
        
    }
    
}
