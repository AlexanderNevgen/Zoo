package servlets;

import lombok.SneakyThrows;
import mapper.VisitorMapper;

import services.VisitorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateVisitor")
public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/updateVisitor.jsp");

        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VisitorService.updateVisitor(VisitorMapper.mapperVisitor(req.getParameter("firstname"),Integer.parseInt(req.getParameter("ticketCount"))), Integer.parseInt(req.getParameter("id")));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");

        requestDispatcher.forward(req, resp);

    }
}
