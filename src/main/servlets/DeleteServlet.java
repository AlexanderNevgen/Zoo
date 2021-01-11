package servlets;

import services.DeleteVisitor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteVisitor")
public class DeleteServlet extends HttpServlet  {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/deleteVisitor.jsp");

        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DeleteVisitor.deleteVisitor(Integer.parseInt(req.getParameter("Id")));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");

        requestDispatcher.forward(req, resp);

    }
}
