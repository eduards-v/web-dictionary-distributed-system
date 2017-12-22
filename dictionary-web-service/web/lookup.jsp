<%@ page import="ie.gmit.sw.ds.service.facade.queues.QueueType" %>
<%@ page import="ie.gmit.sw.ds.service.facade.RMICommandDispatcher" %>
<%@ page import="ie.gmit.sw.ds.service.domain.WordEntity" %>
<%@ page import="ie.gmit.sw.ds.service.facade.queues.result.RMIResultsRetriever" %>
<%@ page import="ie.gmit.sw.ds.service.facade.queues.result.ConcreteResultsRetriever" %>
<%@ page import="java.util.concurrent.Callable" %><%--
  Created by IntelliJ IDEA.
  User: eduar
  Date: 22/12/2017
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary lookup page</title>

</head>
<body>
    <h2>Search dictionary for words</h2>

    <br>
    <form action="" name = "findWord" method="post">
        <input name="wordInput" placeholder="type the word to find" size="32">
        <input type="submit" value="Submit">
    </form>
    <br>

    <%
       int jobId = 0;
       String word = "";
       if(request.getMethod().equals("POST")) {
           // get input parameters
           word = request.getParameter("wordInput");

           // set up entity
           WordEntity wordEntity = new WordEntity(word);
           // get command dispatcher to send RMI request
           RMICommandDispatcher dispatcher = new RMICommandDispatcher(wordEntity);
           // dispatch command , get back job id
           jobId = dispatcher.execute(QueueType.LOOK_UP_CMD);

           // object to retrieve results
           RMIResultsRetriever retriever = new ConcreteResultsRetriever();
    %>


    Retrieving Result: <%
             // try get results
            try {
                wordEntity = retriever.retrieve(jobId);

                while(wordEntity.getWord().isEmpty()){
                    Thread.sleep(1000);
                    wordEntity = retriever.retrieve(jobId);
                }
                out.print(wordEntity.getWord() + " - " +
                          wordEntity.getDescription());
            } catch (InterruptedException e) {
                out.print("Ops, something bad happened during retrieval...");
            }
        }%>


</body>
</html>
