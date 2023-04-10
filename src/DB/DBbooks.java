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
        5111,
        "qwertyuisdfghjsdghj")
    );
    books.add(new Books(2,
        "Harry2",
        "Joane2 Rawling",
        "Horror",
        5111,
        "cvbnm,")
    );
    books.add(new Books(3,
        "Harry3",
        "Joane3 Iron man",
        "Comics",
        5111,
        "sdf")
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
  public  static Books getBook(int id){
    return books.stream().filter(books1 -> books1.getId()==id).findFirst().orElse(null);
  }
  public static void updateBook(Books kitap){
   for(int i=0;i<books.size();i++){
     if(books.get(i).getId()== kitap.getId()){
       books.set(i,kitap);
       break;
     }
  }
  }

}

