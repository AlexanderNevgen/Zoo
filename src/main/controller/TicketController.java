package main.controller;

import main.dto.TicketDTO;
import main.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/findTicketById/{id}")
    @ResponseBody
    public List<TicketDTO> findTicketById(@PathVariable (name = "id") final Long id) {

        return ticketService.getTicketsByVisitorId(id);
    }

    @GetMapping(value = "/getAllTickets")
    @ResponseBody
    public List<TicketDTO> getAllTickets() {

        return ticketService.getAllTickets();
    }
}
