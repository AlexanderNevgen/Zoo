package main.controller;

import main.dto.SaveVisitorDTO;
import main.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import main.services.VisitorService;

import java.util.List;

@Controller
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService){

        this.visitorService = visitorService;
    }

    @PostMapping(value = "/addVisitor")

    public Long addVisitor(@RequestBody SaveVisitorDTO saveVisitorDTO) {

        return visitorService.saveVisitor(saveVisitorDTO);
    }

    @DeleteMapping(value = "/deleteVisitor{id}")
    public Long deleteVisitor(@PathVariable (name = "id" ) final Long id) {

        return visitorService.deleteVisitorById(id);
    }

    @GetMapping(value = "/getAllVisitors")
    @ResponseBody
    public  List<Visitor> getAllVisitors() {

        return visitorService.getAllVisitors();
    }

    @PostMapping(value = "/findVisitorByName")
    @ResponseBody
    public List<Visitor> findVisitorByName(@RequestBody Visitor visitor) {

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
