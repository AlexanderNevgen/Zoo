package main.services;

import main.dto.TicketDTO;
import main.model.Ticket;
import main.model.Visitor;
import main.repository.TicketDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketDao ticketDao;

    @Autowired
    public TicketService(TicketDao ticketDao){

        this.ticketDao = ticketDao;
    }

    public List<TicketDTO> getTicketsByVisitorId(int id)  {
        return ticketDao.findTicketByVisitorId(id).stream().map(this::convertToTicketDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> getAllTickets() {
        return ticketDao.findAll().stream().map(this::convertToTicketDTO)
                .collect(Collectors.toList());
    }

    private TicketDTO convertToTicketDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setDateOfVisit(ticket.getDate());
        Visitor visitor = Ticket.getVisitor();
        ticketDTO.setFirstName(visitor.getFirstName());
        ticketDTO.setLastName(visitor.getLastName());
        return ticketDTO;
    }
}
