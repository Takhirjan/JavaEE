package DB;

import models.Books;

import java.util.ArrayList;

public class DBbooks {
  private static int id=4; //4 потому что книг 3, 4 это следующее
  private static final ArrayList<Books> books=  new ArrayList<>();
  static{
    books.add(new Books(1,
        "Harry1",
        "Joane Rawling",
        "Fantasy",
        5111)
    );
    books.add(new Books(2,
        "Harry2",
        "Joane2 Rawling",
        "Horror",
        5111)
    );
    books.add(new Books(3,
        "Harry3",
        "Joane3 Iron man",
        "Comics",
        5111)
    );
  }

  public static ArrayList<Books> getBooks() {
    return books; //метод который возвращает список книг
  }
  public static void addBook(Books book){
    book.setId(id);
    books.add(book);
    id++;
  }
}

