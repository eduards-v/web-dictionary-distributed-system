package ie.gmit.sw.ds;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.RMICommandDispatcher;
import ie.gmit.sw.ds.service.facade.commands.RMICommandTypes;
import ie.gmit.sw.ds.service.facade.queues.InQueueListener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// annotations removes the need to define servlets classes and url paths in web.xml
@WebServlet(value = "/findWord", loadOnStartup = 1)
public class DictionaryServiceHandler extends HttpServlet{

    private Logger logger = Logger.getLogger("DictionaryServiceHandlerLogger");



    @Override
    public void init() throws ServletException {

        //The servlet context is the application itself.
        ServletContext ctx = getServletContext();

        // Start InQueue listener
        InQueueListener.getInstance().start();

        String word = "hello";

        RMICommandDispatcher dispatcher = new RMICommandDispatcher();
        DictionaryJob job = new DictionaryJob(word);
        dispatcher.setJob(job);
        dispatcher.execute(RMICommandTypes.QUEUE_REQUEST_CMD);

        job = dispatcher.getJob();

        System.out.println(job.getJobId());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        logger.log( Level.INFO,"doGet() method");

        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        // redirects to index.jsp
        resp.setHeader("Location", "http://localhost:8080/");
        // make sure to set status 302 Found
        resp.setStatus(HttpServletResponse.SC_FOUND);
        logger.log( Level.INFO,"doPost() method result: ");
        logger.log( Level.INFO, req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

    }
}
