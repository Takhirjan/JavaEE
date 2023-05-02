package models;

public class Author {
  private int id;
  private String firstname;
  private String lastname;
  private String instagram;

  public Author() {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.instagram = instagram;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public String getInstagram() {
    return instagram;
  }

  public void setInstagram(String instagram) {
    this.instagram = instagram;
  }
}
