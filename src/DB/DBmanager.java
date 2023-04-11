package DB;

import models.users;

import java.util.ArrayList;

public class DBmanager {
  public static ArrayList<users> users = new ArrayList<>();

  static {
    users.add(new users(1L,"ilyas","zhuanyshev","IT",5000));
    users.add(new users(2L, "Aybek", "Bagit", "Management", 650000));
    users.add(new users(3L, "Alibek", "Serikov", "HR", 350000));
    users.add(new users(4L, "Serzhan", "Berikov", "IT", 450000));
    users.add(new users(5L, "Anel", "Mukhamejanova", "Management", 550000));
  }
public static ArrayList<users> getAllUsers(){
    return users;
  }
}