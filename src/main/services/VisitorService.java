package main.services;

import main.dto.VisitorWithTicketsDTO;
import main.model.Ticket;
import main.model.Visitor;
import main.repository.VisitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorService {

    private final VisitorDao visitorDao;

    @Autowired
    public VisitorService(VisitorDao visitorDao){

        this.visitorDao = visitorDao;
    }

    public int saveVisitor(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.save(visitor);
        return visitor.getId();
    }

    public int deleteVisitor(int id) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.delete(id);
        return id;
    }

    public int updateVisitor(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
        visitorDao.update(visitor);
        return visitor.getId();
    }

    public List<VisitorWithTicketsDTO> findVisitorByName(String firstName, String lastName) throws SQLException, IOException, ClassNotFoundException {
        return visitorDao.findVisitorByName(firstName, lastName).stream().map(this::convertToVisitorWithTicketsDTO)
                .collect(Collectors.toList());
    }

    public List<VisitorWithTicketsDTO> getAllVisitors() throws SQLException, IOException, ClassNotFoundException {
        return visitorDao.findAll().stream().map(this::convertToVisitorWithTicketsDTO)
                .collect(Collectors.toList());
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
