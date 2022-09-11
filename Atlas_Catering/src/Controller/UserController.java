package test;

import ADT.ArrayList;

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

    public void updateUser(int index, String column, String value) {
        User user = this.users.getEntry(index);
        switch(column) {
            case "username":
                user.setUsername(value);
                break;
            case "name":
                user.setName(value);
                break;
            case "email":
                user.setEmail(value);
                break;
            case "phoneNumber":
                user.setPhoneNumber(Integer.parseInt(value));
                break;
            case "gender":
                user.setGender(value);
                break;
            case "password":
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

}
