package main.zoo.controller;

import main.zoo.mapper.VisitorMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import main.zoo.model.Visitor;
import main.zoo.services.VisitorService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class VisitorController {

    //@Autowired
    VisitorService visitorService = new VisitorService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/visitor", method = RequestMethod.GET)
    public ModelAndView visitor() {
        return new ModelAndView("addVisitor", "command", new Visitor());
    }

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    public String addVisitor(HttpServletRequest req) throws SQLException, IOException, ClassNotFoundException {

        visitorService.saveVisitor(VisitorMapper.mapperVisitor(req.getParameter("firstName"),Integer.parseInt(req.getParameter("ticketCount"))));

        return "index";
    }

    @RequestMapping(value = "/deleteVisitor", method = RequestMethod.GET)
    public String inputVisitorIdToDelete(){

        return "deleteVisitor";
    }

    @RequestMapping(value = "/deleteVisitor", method = RequestMethod.POST)
    public String deleteVisitor(HttpServletRequest req) throws SQLException, IOException, ClassNotFoundException {

        visitorService.deleteVisitor(Integer.parseInt(req.getParameter("Id")));

        return "index";
    }

    @RequestMapping(value = "/getAllVisitors", method = RequestMethod.GET)
    public String getAllVisitors(HttpServletRequest req) throws SQLException, IOException, ClassNotFoundException {

        req.setAttribute("list", visitorService.findAllVisitors());

        return "visitorList";
    }

    @RequestMapping(value = "/findTicketById", method = RequestMethod.GET)
    public String inputVisitorIdToFindTicket(){

        return "inputVisitorIdToFindTicket";
    }

    @RequestMapping(value = "/findTicketById", method = RequestMethod.POST)
    public String findTicketById(HttpServletRequest req) throws SQLException, IOException, ClassNotFoundException {

        req.setAttribute("list", visitorService.find(Integer.parseInt(req.getParameter("VisitorId"))));

        return "findTicketById";
    }

    @RequestMapping(value = "/updateVisitor", method = RequestMethod.GET)
    public String inputDataToUpdateVisitor(){

        return "updateVisitor";
    }

    @RequestMapping(value = "/updateVisitor", method = RequestMethod.POST)
    public String updateVisitor(HttpServletRequest req) throws SQLException, IOException, ClassNotFoundException {

        visitorService.updateVisitor(VisitorMapper.mapperVisitor(req.getParameter("firstname"),Integer.parseInt(req.getParameter("ticketCount"))), Integer.parseInt(req.getParameter("id")));

        return "index";
    }
}
