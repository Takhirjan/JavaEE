package DB;

import com.mysql.cj.jdbc.Driver;
import models.Book;

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
        PreparedStatement statement= connection.prepareStatement("SELECT *  FROM books"); // 1
        ResultSet resultSet=statement.executeQuery(); // весь результат из 1 попадает сюда
        while (resultSet.next()){       //Должен провести итерацию и закинуть каждый resultset в Arraylist
          Book book=new Book();
          book.setId(resultSet.getInt("id"));
          book.setName(resultSet.getString("name"));
          book.setAuthor(resultSet.getString("author"));
          book.setGenre(resultSet.getString("genre"));
          book.setDescription(resultSet.getString("description"));
          book.setPrice(resultSet.getDouble("price"));

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
            "SELECT * FROM books WHERE id=? LIMIT 1");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){  //Он будет один раз вытаскивать или вообще не будет
          book=new Book();
          book.setId(resultSet.getInt("id"));
          book.setName(resultSet.getString("name"));
          book.setAuthor(resultSet.getString("author"));
          book.setGenre(resultSet.getString("genre"));
          book.setDescription(resultSet.getString("description"));
          book.setPrice(resultSet.getDouble("price"));
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
          "INSERT INTO books (name,price,author,genre,description)" +
          "VALUES(?,?,?,?,?)");
        statement.setString(1, book.getName());
        statement.setDouble(2, book.getPrice());
        statement.setString(3, book.getAuthor());
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
      statement.setString(5, book.getAuthor());
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

      }
