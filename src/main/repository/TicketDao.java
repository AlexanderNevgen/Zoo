package main.repository;

import main.dto.TicketDTO;
import main.model.Ticket;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

@Repository
public class TicketDao {

   EntityManagerFactory emf = Persistence.createEntityManagerFactory("tickets");

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    EntityManager em = getEntityManager();

    Long saveTicket(Long visitorId){
        Date date = new Date();
        Ticket ticket = new Ticket();
        ticket.setDate(date);
        ticket.setVisitorId(visitorId);
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
        return ticket.getTicketId();
    }

    public List<TicketDTO> findTicketByVisitorId(Long visitorId){

        return em.createQuery("SELECT ticket from Ticket ticket where ticket.visitorId = ?1")
                .setParameter(1, visitorId)
                .getResultList();
    }

    public List<TicketDTO> getAllTickets (){

        return em.createQuery("Select ticket from Ticket ticket").getResultList();
    }
}
