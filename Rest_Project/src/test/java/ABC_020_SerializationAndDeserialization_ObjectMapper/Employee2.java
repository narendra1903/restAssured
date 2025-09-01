package ABC_020_SerializationAndDeserialization_ObjectMapper;

import java.util.ArrayList;

public class Employee2 {

	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private double salary;
	
	private ArrayList<Employee2> EmployeeList = new ArrayList<Employee2>();

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ArrayList<Employee2> getEmployeeList() {
		return EmployeeList;
	}

	public void setEmployeeList(ArrayList<Employee2> employeeList) {
		EmployeeList = employeeList;
	}
	
	
	
}
