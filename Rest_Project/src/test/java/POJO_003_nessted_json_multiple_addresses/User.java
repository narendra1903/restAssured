package POJO_003_nessted_json_multiple_addresses;

import java.util.List; 

public class User { 
    private String name; 
    private String email; 
    private int age; 
    private List<Address> addresses; 
 
    public User() {} 
 
    public User(String name, String email, int age, List<Address> addresses) { 
        this.name = name; 
        this.email = email; 
        this.age = age; 
        this.addresses = addresses; 
    } 
 
    // Getters and setters 
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
 
    public int getAge() { 
        return age; 
    } 
 
    public void setAge(int age) { 
        this.age = age; 
    } 
 
    public List<Address> getAddresses() { 
        return addresses; 
    } 
 
    public void setAddresses(List<Address> addresses) { 
        this.addresses = addresses; 
    } 
}