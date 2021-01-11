package servlets;

//import servlets.DBConnection;

import services.FindTicketById;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findTicketById")
public class FindTicketByIdServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/inputVisitorIdToFindTicket.jsp");

        requestDispatcher.forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/findTicketById.jsp");

        req.setAttribute("list", FindTicketById.findTicketById(Integer.parseInt(req.getParameter("VisitorId"))));

        requestDispatcher.forward(req, resp);

    }
}
