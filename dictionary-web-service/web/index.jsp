<%--
  Created by IntelliJ IDEA.
  User: eduar
  Date: 16/12/2017
  Time: 01:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>English Dictionary</title>
  </head>
  <body>

        <h1>Dictionary Service</h1>
        <form action="findWord" method="post">
            <input name="wordInput" placeholder="type the word to find" size="32">
            <input type="submit" value="Submit">
        </form>
  </body>
</html>
