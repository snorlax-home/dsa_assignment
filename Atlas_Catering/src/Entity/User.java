package Entity;

public class User {
    String username;
    String name;
    String email;
    int phoneNumber;
    String gender;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        name = null;
        email = null;
        phoneNumber = 0;
        gender = null;
    }

    public User(String username, String name, String email,int phoneNumber,String gender, String password ){
        this.username = username;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-10s \n", username, password);
    }

}
