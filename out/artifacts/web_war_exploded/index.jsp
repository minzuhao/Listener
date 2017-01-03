<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zdy.entity.User" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
当前在线用户人数：${userNumber}<br />
  <%
    ArrayList<User> userList=(ArrayList<User>)request.getServletContext().getAttribute("userList");
    if (userList!=null){
      for (User user:userList) {
        %>
      IP:<%=user.getIp()%>——FirstTime:<%=user.getFirstTime()%>——SessionId:<%=user.getSessionId()%><br />
  <%
      }
    }
  %>
  </body>
</html>