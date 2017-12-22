<%@ page import="ie.gmit.sw.ds.service.domain.WordEntity" %>
<%@ page import="ie.gmit.sw.ds.service.facade.RMICommandDispatcher" %>
<%@ page import="ie.gmit.sw.ds.service.facade.queues.QueueType" %><%--
  Created by IntelliJ IDEA.
  User: eduar
  Date: 22/12/2017
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new word for dictionary</title>
</head>
<body>
    <h2>Create a new word for dictionary</h2>

    <form action="" name = "createWord" method="post">
        <input name="wordInput" placeholder="type new word to add" size="32">
        <input name="wordDesc" placeholder="type description of new word" size="32">
        <input type="submit" value="Submit">
    </form>

    <%
        if(request.getMethod().equals("POST")) {
            String word = request.getParameter("wordInput");
            String desc = request.getParameter("wordDesc");

            WordEntity wordEntity = new WordEntity(word, desc);

            RMICommandDispatcher dispatcher = new RMICommandDispatcher(wordEntity);
            dispatcher.execute(QueueType.ADD_CMD);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    %>

</body>
</html>
