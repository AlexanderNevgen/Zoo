package main.config;

import main.repository.TicketDao;
import main.repository.VisitorDao;
import main.services.TicketService;
import main.services.VisitorService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "main")
public class SpringConfig {

    @Bean
    public VisitorService visitorService() {
        return new VisitorService(visitorDao());
    }

    @Bean
    public TicketService ticketService() {
        return new TicketService(ticketDao());
    }

    @Bean (name = "ticketDao")
    public TicketDao ticketDao() {
        return TicketDao.createTicketDao();
    }

    @Bean (name = "visitorDao")
    public VisitorDao visitorDao() {
        return VisitorDao.createVisitorDao();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
