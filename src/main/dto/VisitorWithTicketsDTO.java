package main.dto;

import lombok.Data;
import main.model.Ticket;

import java.util.List;

@Data
public class VisitorWithTicketsDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private int ticketCount;
    private List<Ticket> tickets;
}
