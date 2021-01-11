package servlets;

import services.GetListOfVisitors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getAllVisitors")
public class GetServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/visitorList.jsp");

        req.setAttribute("list", GetListOfVisitors.getALLVisitors());

        requestDispatcher.forward(req, resp);

    }
}