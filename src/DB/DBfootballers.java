package DB;

import models.Footballer;

import java.util.ArrayList;

public class DBfootballers {
  public static ArrayList<Footballer> footballers=new ArrayList<>();
  private static Long id=5L;
        static{
          footballers.add(new Footballer(1L,"Lionell", "Messi",55000,"PSC",2000000));
          footballers.add(new Footballer(2L,"Cristiano", "Ronaldo",650000,"real",1000000));
          footballers.add(new Footballer(3L,"Lionel3", "Salah",55500,"Barsa",2050000));
          footballers.add(new Footballer(4L,"NoName", "Inknow",45000,"PSC",500000));
        }
  public static ArrayList<Footballer> getFootballers(){
          return footballers;
  }
      public static void addFootballers(Footballer footballer){
          footballer.setId(id);
          footballers.add(footballer);
          id++;
      }
}