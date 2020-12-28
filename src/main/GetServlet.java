import model.Visitor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/getAllVisitors")
public class GetServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/visitorList.jsp");

        LinkedList <Visitor> visitList = DBConnection.getALLVisitors();

        req.setAttribute("list", DBConnection.getALLVisitors());

        requestDispatcher.forward(req, resp);

    }
}
