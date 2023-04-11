package models;

public class users {
  private Long id;
  private String name;
  private String surname;
  private String department;
  private int salary;

  public users(Long id, String name, String surname, String department, int i) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.department = department;
    this.salary=salary;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
}
