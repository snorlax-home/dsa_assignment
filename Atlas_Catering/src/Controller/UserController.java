package Controller;

import java.util.logging.LogManager;

import ADT.ArrayList;
import Entity.User;

public class UserController {
    private ArrayList<User> users;
    private boolean isRunning;

    public UserController() {
        this.users = new ArrayList<>();
        this.isRunning = true;
    }
    
    public void createUser(User user) {
        this.users.add(user);
    }

    public ArrayList<User> readUsers() {
        return this.users;
    }

    public int getUserIndex(User user) {
        return this.users.getIndex(user);
    }

    public User readUser(int index) {
        return this.users.getEntry(index);
    }

    public void createUser(String username, String password) {
        this.users.add(new User(username, password)); 
    }

    public void deleteUser(User user) {
        //this.user.findAll();
        int index = this.users.getIndex(user);
        if(index != -1) {
            this.users.remove(index);
        }
    }

    public void deleteUser(int index) {
        this.users.remove(index);
    }

    public void updateUser(int index, String column, String value) {
        User user = this.users.getEntry(index);
        switch(column) {
            case "Username":
                user.setUsername(value);
                break;
            case "Name":
                user.setName(value);
                break;
            case "Email":
                user.setEmail(value);
                break;
            case "PhoneNumber":
                user.setPhoneNumber(Integer.parseInt(value));
                break;
            case "Gender":
                user.setGender(value);
                break;
            case "Password":
                user.setPassword(value);
                break;
        }
        this.users.replace(index, user);
    }

    public boolean hasUser() {
        return !this.users.isEmpty();
    }

    public void clearAllUser(){
        this.users.clear();
    }

    public boolean programRunning() {
        return this.isRunning;
    } 

    public void endProgram(){
        this.isRunning = false;
    }

    public int usersAmount(){
        return this.users.getNumberOfEntries();
    }

}
