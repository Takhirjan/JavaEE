package DB;

import models.Book;

import java.util.ArrayList;

public class DBbooks {
  private static final ArrayList<Book> books=  new ArrayList<>();
  private static int id=4; //4 потому что книг 3, 4 это следующее

  static{
    books.add(new Book(1,
        "Harry1",
        "Joane Rawling",
        "Fantasy",
        8000,
        "qwertyuisdfghjsdghj")
    );
    books.add(new Book(2,
        "Harry2",
        "Joane2 Rawling",
        "Horror",
        9000,
        "cvbnm,")
    );
    books.add(new Book(3,
        "Harry3",
        "Joane3 Iron man",
        "Comics",
        100000,
        "sdf")
    );
  }

  public static ArrayList<Book> getBooks() {
    return books; //метод который возвращает список книг
  }
  public static void addBook(Book book){
    book.setId(id);
    books.add(book);
    id++;
  }
  public  static Book getBook(int id){
    return books.stream().filter(book -> book.getId()==id).findFirst().orElse(null);
  }
  public static void updateBook(Book kitap) {
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getId() == kitap.getId()) {
        books.set(i, kitap);
        break;
      }
    }
  }
  public static void deleteBook(int id) {
    for (int i = 0; i < books.size(); i++) {
      if(books.get(i).getId()==id){
        books.remove(i);
        break;
      }
    }
  }
}

