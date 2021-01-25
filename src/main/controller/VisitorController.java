package main.controller;

import main.dto.VisitorWithTicketsDTO;
import main.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import main.services.VisitorService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService){

        this.visitorService = visitorService;
    }

    @PostMapping(value = "/addVisitor")
    public int addVisitor(@RequestBody Visitor visitor) throws SQLException, IOException, ClassNotFoundException {

        return visitorService.saveVisitor(visitor);
    }

    @DeleteMapping(value = "/deleteVisitor{id}")
    public int deleteVisitor(@PathVariable (name = "id" ) final Integer id) throws SQLException, IOException, ClassNotFoundException {

        return visitorService.deleteVisitor(id);
    }

    @GetMapping(value = "/getAllVisitors")
    @ResponseBody
    public  List<VisitorWithTicketsDTO> getAllVisitors() throws SQLException, IOException, ClassNotFoundException {

        return visitorService.getAllVisitors();
    }

    @PostMapping(value = "/findVisitorByName")
    @ResponseBody
    public  List<VisitorWithTicketsDTO> findVisitorByName(@RequestBody Visitor visitor) throws SQLException, IOException, ClassNotFoundException {

        return visitorService.findVisitorByName(visitor.getFirstName(), visitor.getLastName());
    }

    @PutMapping(value = "/updateVisitor")
    public int updateVisitor(@RequestBody Visitor visitor) throws SQLException, IOException, ClassNotFoundException {

        return visitorService.updateVisitor(visitor);
    }
}
