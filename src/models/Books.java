package models;

public class Books {
  private int id;
  private String name;
  private String author;
  private String genre;
  private double price;

  public Books(int id, String name, String author, String genre, double price) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
    this.price = price;
  }

  public Books() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice() {
    this.price = price;
  }

  public void setPrice(double bookPrice) {
  }
}
