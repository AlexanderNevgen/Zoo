package main.controller;

import main.dto.SaveVisitorDTO;
import main.dto.VisitorsFullNameDTO;
import main.model.Visitor;
import main.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import main.services.VisitorService;
import java.util.List;

@Controller
public class VisitorController {

    private final VisitorService visitorService;
    private final TicketService ticketService;

    @Autowired
    public VisitorController(VisitorService visitorService, TicketService ticketService){

        this.visitorService = visitorService;
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/addVisitor")

    public Long addVisitor(@RequestBody SaveVisitorDTO saveVisitorDTO) {

        visitorService.saveVisitor(saveVisitorDTO.getVisitor());
        ticketService.saveTicket(saveVisitorDTO.getVisitor().getId(), saveVisitorDTO.getDepartment());
        return saveVisitorDTO.getVisitor().getId();
    }

    @DeleteMapping(value = "/deleteVisitor{id}")
    public Long deleteVisitor(@PathVariable Long id) {

        return visitorService.deleteVisitorById(id);
    }

    @GetMapping(value = "/getAllVisitors")
    @ResponseBody
    public  List<Visitor> getAllVisitors() {

        return visitorService.getAllVisitors();
    }

    @PostMapping(value = "/findVisitorByName")
    @ResponseBody
    public List<Visitor> findVisitorByName(@RequestBody VisitorsFullNameDTO visitor) {

        return visitorService.findVisitorByName(visitor.getFirstName(), visitor.getLastName());
    }

    @GetMapping(value = "/getVisitorById{id}")
    @ResponseBody
    public Visitor findVisitorById(@PathVariable Long id) {

        return visitorService.getVisitorById(id);
    }

    @PutMapping(value = "/updateVisitor")
    public Long updateVisitor(@RequestBody Visitor visitor) {

        return visitorService.updateVisitor(visitor);
    }
}
