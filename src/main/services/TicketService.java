package main.services;

import main.dto.TicketDTO;
import main.model.Department;
import main.model.Ticket;
import main.model.Visitor;
import main.repository.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    private final TicketDao ticketDao;

    @Autowired
    public TicketService(TicketDao ticketDao){

        this.ticketDao = ticketDao;
    }

    public List<TicketDTO> getTicketsByVisitorId(Long id)  {

        return ticketDao.findTicketByVisitorId(id);
    }

    public void saveTicket(Long visitorId, Department department){
        Date date = new Date();
        Ticket ticket = new Ticket();
        ticket.setDate(date);
        ticket.setVisitorId(visitorId);
        ticket.addDepartment(department);
        ticketDao.saveTicket(ticket);
    }

    public List<TicketDTO> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    public TicketDTO convertToTicketDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setDateOfVisit(ticket.getDate());
        Visitor visitor = ticket.getVisitor();
        ticketDTO.setFirstName(visitor.getFirstName());
        ticketDTO.setLastName(visitor.getLastName());
        return ticketDTO;
    }
}
