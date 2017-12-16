package ie.gmit.sw.ds;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/DictionaryServlet")
public class DictionaryServiceHandler extends HttpServlet{


    @Override
    public void init() throws ServletException {

        //The servlet context is the application itself.
        ServletContext ctx = getServletContext();

        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
