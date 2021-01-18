package servlets;

import lombok.SneakyThrows;
import mapper.*;
import services.VisitorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebServlet("/addVisitor")
public class AddServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/addVisitor.jsp");

        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VisitorService.saveVisitor(VisitorMapper.mapperVisitor(req.getParameter("Firstname"),Integer.parseInt(req.getParameter("TicketCount"))));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");

        requestDispatcher.forward(req, resp);

    }
}
*/