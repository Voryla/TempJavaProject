<%--
  Created by IntelliJ IDEA.
  User: ZWK
  Date: 2019/5/6
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! int fontSize; %>
<html>
  <head>
    <title>我的第一个jsp</title>
  </head>
  <body>
  <%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
  <font color="green" size="<%= fontSize %>">
    JSP Tutorial
  </font><br />
  <%}%>
  <%for (int i = 0; i < 5; i++) {%>
  <%=i%>
  <br/>
  <%}%>

  </body>
</html>
