package services;

import model.Ticket;
import model.Visitor;
import repository.VisitorDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VisitorService {

    private static VisitorDao visitorDao = new VisitorDao();

    public VisitorService() {
    }

    public static void saveVisitor(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.save(visitor);
    }

    public static void deleteVisitor(int id) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.delete(id);
    }

    public static void updateVisitor(Visitor visitor, int id) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.update(visitor, id);
    }

    public static LinkedList<Visitor> findAllVisitors() throws SQLException, IOException, ClassNotFoundException {
        return visitorDao.findAll();
    }

    public static List<Ticket> find(int id) throws SQLException, IOException, ClassNotFoundException {
        return visitorDao.findTicketById(id);
    }
}
