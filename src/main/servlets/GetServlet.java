package servlets;

import lombok.SneakyThrows;
import services.VisitorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebServlet("/getAllVisitors")
public class GetServlet extends HttpServlet {


    @SneakyThrows
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/visitorList.jsp");

        req.setAttribute("list", VisitorService.findAllVisitors());

        requestDispatcher.forward(req, resp);

    }
}*/