package pay;

import java.util.Objects;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
*/
import jakarta.persistence.*;

@Entity
public class Employee {

  private @Id @GeneratedValue Long id;
  //private String name;
  private String firstName;
  private String lastName;
  private String role;

  public Employee() {}

  public Employee(String firstName, String lastName, String role) {
    //this.name = name;
	this.firstName = firstName;
	this.lastName = lastName;
    this.role = role;
  }

  public Long getId() {
    return this.id;
  }
  /*
  public String getName() {
    return this.name;
  }
  */
  public String getName() {
	 return this.firstName + " " + this.getLastName();
  }
  
  public String getRole() {
    return this.role;
  }

  public String getFirstName() {
	return firstName;
}

  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }

  public String getLastName() {
	return lastName;
  }

  public void setLastName(String lastName) {
	this.lastName = lastName;
  }

  public void setId(Long id) {
    this.id = id;
  }
  /*
  public void setName(String name) {
    this.name = name;
  }
  */
  public void setName(String name) {
	 String[] parts = name.split(" ");
	 this.firstName = parts[0];
	 if(parts.length > 1) this.lastName = parts[1];
  }
	
  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Employee))
      return false;
    Employee employee = (Employee) o;
    /*
    return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
        && Objects.equals(this.role, employee.role);
    */
    return Objects.equals(this.id, employee.id) 
    		&& Objects.equals(this.firstName, employee.firstName)
    		&& Objects.equals(this.lastName, employee.lastName)
            && Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    //return Objects.hash(this.id, this.name, this.role);
	return Objects.hash(this.id, this.firstName, this.role);
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id + ", name='" 
    		+ this.firstName + "_" + this.lastName + '\'' 
    		+ ", role='" + this.role + '\'' + '}';
  }
}