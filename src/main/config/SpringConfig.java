package main.config;

import main.repository.TicketDao;
import main.repository.VisitorDao;
import main.services.TicketService;
import main.services.VisitorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "main")
public class SpringConfig {


}
