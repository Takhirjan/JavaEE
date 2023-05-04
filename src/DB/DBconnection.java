package DB;

import models.Author;
import models.Book;
import models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBconnection {

  private static Connection connection;
    static{
      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/newtechordadb",
            "root","");
      }catch (Exception e){
          e.printStackTrace();
      }
    }
    public static ArrayList<Book> getBooks(){
      ArrayList<Book> books=new ArrayList<>(); //2  //Сохраняю запрос select from books
      try{
        PreparedStatement statement= connection.prepareStatement(
            "select bo.id, bo.name,bo.genre,bo.price,bo.description,bo.author_id,a.first_name,a.last_name,a.instagram " +
                     "FROM books as bo "+
                     "inner join authors a on bo.author_id = a.id " +
                     " order by bo.price desc"); // 1
        ResultSet resultSet=statement.executeQuery(); // весь результат из 1 попадает сюда
        while (resultSet.next()){       //Должен провести итерацию и закинуть каждый resultset в Arraylist
          Book book=new Book();
          book.setId(resultSet.getInt("id"));
          book.setName(resultSet.getString("name"));
          book.setGenre(resultSet.getString("genre"));
          book.setDescription(resultSet.getString("description"));
          book.setPrice(resultSet.getDouble("price"));

          Author author=new Author();
          author.setId(resultSet.getInt("author_id"));
          author.setLastname(resultSet.getString("last_name"));
          author.setFirstname(resultSet.getString("first_name"));
          author.setInstagram(resultSet.getString("instagram"));

           book.setAuthor(author);
           books.add(book);
        }
        statement.close();
      }catch(Exception e){
        e.printStackTrace();
      }
      return books;
    }

  public static Book getBook(int id) {  //this method for details
    Book book = null;
      try {
        PreparedStatement statement= connection.prepareStatement(""+
            "select bo.id, bo.name,bo.genre,bo.price,bo.description,bo.author_id,a.first_name,a.last_name,a.instagram " +
            "FROM books as bo "+
            "inner join authors a on bo.author_id = a.id " +
            " where bo.id=? ");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){  //Он будет один раз вытаскивать или вообще не будет
          book=new Book();
          book.setId(resultSet.getInt("id"));
          book.setName(resultSet.getString("name"));
          book.setGenre(resultSet.getString("genre"));
          book.setDescription(resultSet.getString("description"));
          book.setPrice(resultSet.getDouble("price"));

          Author author=new Author();
          author.setId(resultSet.getInt("author_id"));
          author.setFirstname(resultSet.getString("first_name"));
          author.setLastname(resultSet.getString("last_name"));
          author.setInstagram(resultSet.getString("instagram"));
          book.setAuthor(author);
        }
        statement.close();
      }catch (Exception e){
        e.printStackTrace();
      }
      return book;
        }
    public static void addBook(Book book){
      try{
      PreparedStatement statement= connection.prepareStatement(""+
          "INSERT INTO books (name,price,author_id,genre,description)" +
          "VALUES(?,?,?,?,?)");
        statement.setString(1, book.getName());
        statement.setDouble(2, book.getPrice());
        statement.setInt(3, book.getAuthor().getId());
        statement.setString(4, book.getGenre());
        statement.setString(5, book.getDescription());

        statement.executeUpdate(); //отправить запрос
        statement.close();

      }catch (Exception e){
        e.printStackTrace();
      }
    }

    public static void updateBook(Book book){
    try{
    PreparedStatement statement= connection.prepareStatement(""+
                          "UPDATE books "+
                          "SET " +
                          "name = ?, "+
                          "price = ?,"+
                          "genre = ?, "+
                          "description = ?," +
                          "author = ? " +
                          "WHERE id = ?");

      statement.setString(1, book.getName());
      statement.setDouble(2, book.getPrice());
      statement.setString(3, book.getGenre());
      statement.setString(4, book.getDescription());
      statement.setInt(5, book.getAuthor().getId());
      statement.setInt(6, book.getId());

      statement.executeUpdate(); //отправить запрос
      statement.close();
    }catch (Exception e){
      e.printStackTrace();
    }
    }

    public static void deleteBook(int id){
      try{
        PreparedStatement statement= connection.prepareStatement(""+
              "DELETE FROM books WHERE id = ?");
        statement.setInt(1,id);
        statement.executeUpdate();
        statement.close();
      }catch (Exception e){
        e.printStackTrace();
      }
    }
      public static ArrayList<Author> getAuthors(){  ///вытаскиваю свписок авторов
      ArrayList<Author> authors=new ArrayList<>();
      try {
      PreparedStatement statement= connection.prepareStatement(""+
              "select * from authors order by first_name asc"
          );
      ResultSet resultSet= statement.executeQuery();
      while(resultSet.next()){
        Author author=new Author();
        author.setId(resultSet.getInt("id"));
        author.setFirstname(resultSet.getString("first_name"));
        author.setLastname(resultSet.getString("last_name"));
        author.setInstagram(resultSet.getString("instagram"));
        authors.add(author);
      }
      statement.close();
      }catch (Exception e){
        e.printStackTrace();
      }
      return authors;
      }

      //вытаскивает книгу по одной id
        public static Author getAuthor(int id){
      Author author=null;
      try{
    PreparedStatement statement= connection.prepareStatement(""+"select *from authors where id=?");
    statement.setInt(1,id);
    ResultSet resultSet=statement.executeQuery();
    if(resultSet.next()){
      author=new Author();
      author.setLastname(resultSet.getString("last_name"));
      author.setFirstname(resultSet.getString("first_name"));
      author.setInstagram(resultSet.getString("instagram"));
      author.setId(resultSet.getInt("id"));

    }
    statement.close();
      }catch (Exception e){
        e.printStackTrace();
      }
      return author;
        }
        public static void addAuthor(Author author){
          try{
            PreparedStatement statement= connection.prepareStatement(""+
                "INSERT INTO authors (first_name,last_name,instagram)"+
                "            VALUES (?,?,?)");
            statement.setString(1, author.getFirstname());
            statement.setString(2, author.getLastname());
            statement.setString(3, author.getInstagram());

            statement.executeUpdate();
            statement.close();
          }catch (Exception e){
            e.printStackTrace();
          }
        }
  public static User getUser(String email){
    User user=null;
    try{
      PreparedStatement statement= connection.prepareStatement(""+
          "select *from users where email=?");
      statement.setString(1,email);
      ResultSet resultSet=statement.executeQuery();
      if(resultSet.next()){
        user=new User();
        user.setId(resultSet.getLong("id"));
        user.setFullname(resultSet.getString("full_name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(resultSet.getInt("role_id"));

      }
      statement.close();
    }catch (Exception e){
      e.printStackTrace();
    }
    return user;
  }
  public static void addUser(User user) {
    try {

      PreparedStatement statement = connection.prepareStatement("" +
          "INSERT INTO users (email, password, full_name) " +
          "VALUES (?, ?, ?)");

      statement.setString(1, user.getEmail());
      statement.setString(2, user.getPassword());
      statement.setString(3, user.getFullname());
//      statement.setInt(4, user.getRole());

      statement.executeUpdate();
      statement.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
      }
