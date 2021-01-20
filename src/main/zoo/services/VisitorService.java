package main.zoo.services;

import main.zoo.model.Ticket;
import main.zoo.model.Visitor;
import main.zoo.repository.TicketDao;
import main.zoo.repository.VisitorDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

//@Component
public class VisitorService {

    //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
     //VisitorDao visitorDao;
     //TicketDao ticketDao;

    VisitorDao visitorDao = new VisitorDao();
    TicketDao ticketDao = new TicketDao();

    //@Autowired
    //public VisitorService(VisitorDao visitorDao, TicketDao ticketDao){
    //    this.visitorDao = visitorDao;
   //     this.ticketDao = ticketDao;
  //  }

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
}
