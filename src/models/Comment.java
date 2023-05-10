package models;

import java.sql.Timestamp;

public class Comment {
  private Long id;
  private User user;
  private News news;
  private String comment;
  private Timestamp postdate;

  public Comment() {
    this.id = id;
    this.user = user;
    this.news = news;
    this.comment = comment;
    this.postdate = postdate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public News getNews() {
    return news;
  }

  public void setNews(News news) {
    this.news = news;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Timestamp getPostdate() {
    return postdate;
  }

  public void setPostdate(Timestamp postdate) {
    this.postdate = postdate;
  }
}
