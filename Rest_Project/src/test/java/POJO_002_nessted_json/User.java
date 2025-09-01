package POJO_002_nessted_json;

public class User { 
    private String name; 
    private String email; 
    private int age; 
    private Address address; 
 
    // Constructors 
    public User() {} 
 
    public User(String name, String email, int age, Address address) { 
        this.name = name; 
        this.email = email; 
        this.age = age; 
        this.address = address; 
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
 
    public Address getAddress() { 
        return address; 
    } 
 
    public void setAddress(Address address) { 
        this.address = address; 
    } 
}