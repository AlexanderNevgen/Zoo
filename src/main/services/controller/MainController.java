package services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

        @GetMapping ("/addVisitor")
        public String addNewVisitor () {


            return "views/addVisitor.jsp";
            //return "hello";
        }

}
