package main.config;

import main.repository.TicketDao;
import main.repository.VisitorDao;
import main.services.VisitorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "main")
public class SpringConfig {

    @Bean
    public VisitorService visitorService() {
        return new VisitorService();
    }

    @Bean (name = "ticketDao")
    public TicketDao ticketDao() {
        return TicketDao.createTicketDao();
    }

    @Bean (name = "visitorDao")
    public VisitorDao visitorDao() {
        return VisitorDao.createVisitorDao();
    }
}
