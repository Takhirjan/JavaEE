package models;

public class User {
  private Long id;
  private String email;
  private String password;
  private String fullname;
  private int role;

  public User(Long id, String email, String password, String fullname, int role) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.fullname = fullname;
    this.role = role;
  }

  public User() {
    this.id = id;
    this.email = email;
    this.password = password;
    this.fullname = fullname;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
}
