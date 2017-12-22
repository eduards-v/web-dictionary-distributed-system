<%@ page import="ie.gmit.sw.ds.service.domain.WordEntity" %>
<%@ page import="ie.gmit.sw.ds.service.facade.RMICommandDispatcher" %>
<%@ page import="ie.gmit.sw.ds.service.facade.queues.QueueType" %><%--
  Created by IntelliJ IDEA.
  User: eduar
  Date: 22/12/2017
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete word from dictionary</title>
</head>
<body>
    <h1>Delete word from dictionary</h1>

    <form action="" name = "createWord" method="post">
        <input name="wordInput" placeholder="type word to remove" size="32">
        <input type="submit" value="Submit">
    </form>

    <%
        if(request.getMethod().equals("POST")) {
            String word = request.getParameter("wordInput");

            WordEntity wordEntity = new WordEntity(word);

            RMICommandDispatcher dispatcher = new RMICommandDispatcher(wordEntity);
            dispatcher.execute(QueueType.REMOVE_CMD);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    %>
</body>
</html>
