<%@ page import="models.User" %><%
  User user= (User) request.getSession().getAttribute("curretnUser");
  boolean ONLINE=false;
  if(user!=null){
    ONLINE=true;
  }
%>
