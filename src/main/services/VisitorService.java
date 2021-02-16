package main.services;

import main.dto.VisitorWithTicketsDTO;
import main.model.Ticket;
import main.model.Visitor;
import main.repository.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    private final VisitorDao visitorDao;

    @Autowired
    public VisitorService(VisitorDao visitorDao){

        this.visitorDao = visitorDao;
    }

    public Long saveVisitor(Visitor visitor) {
        return visitorDao.saveVisitor(visitor);
    }

    public Visitor getVisitorById(Long id){
        return visitorDao.getVisitorById(id);
    }

    public Long deleteVisitorById(Long id) {
        return visitorDao.deleteVisitorById(id);
    }

    public Long updateVisitor (Visitor visitor){
        visitorDao.updateVisitor(visitor);
        return visitor.getId();
    }

    public List<Visitor> findVisitorByName(String firstName, String lastName) {
        return visitorDao.findVisitorByName(firstName, lastName);
    }

    public List<Visitor> getAllVisitors() {
        return visitorDao.getAllVisitors();
    }

    private VisitorWithTicketsDTO convertToVisitorWithTicketsDTO(Visitor visitor) {

        VisitorWithTicketsDTO visitorWithTicketsDTO = new VisitorWithTicketsDTO();
        visitorWithTicketsDTO.setId(visitor.getId());
        visitorWithTicketsDTO.setFirstName((visitor.getFirstName()));
        visitorWithTicketsDTO.setLastName((visitor.getLastName()));
        visitorWithTicketsDTO.setAge(visitor.getAge());
        visitorWithTicketsDTO.setTicketCount(visitor.getTicketCount());
        List<Ticket> tickets = visitor.getTicketList();
        visitorWithTicketsDTO.setTickets(tickets);

        return visitorWithTicketsDTO;
    }
}
