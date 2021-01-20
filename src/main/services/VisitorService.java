package main.services;

import main.model.Ticket;
import main.model.Visitor;
import main.repository.TicketDao;
import main.repository.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Service
public class VisitorService {

    @Autowired
    private VisitorDao visitorDao;
    @Autowired
    private TicketDao ticketDao;

    public void saveVisitor(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.save(visitor);
    }

    public void deleteVisitor(int id) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.delete(id);
    }

    public void updateVisitor(Visitor visitor, int id) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.update(visitor, id);
    }

    public LinkedList<Visitor> findAllVisitors() throws SQLException, IOException, ClassNotFoundException {
        return visitorDao.findAll();
    }

    public List<Ticket> find(int id) throws SQLException, IOException, ClassNotFoundException {
        return ticketDao.findTicketByVisitorId(id);
    }
    public List<Visitor> findVisitor(String firstName, String lastName) throws SQLException, IOException, ClassNotFoundException {
        return visitorDao.findVisitorByName(firstName, lastName);
    }
}
