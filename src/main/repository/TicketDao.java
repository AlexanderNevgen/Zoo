package main.repository;

import main.dto.TicketDTO;
import main.model.Ticket;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class TicketDao {

    @PersistenceUnit
    static EntityManager em;

    public void saveTicket(Ticket ticket){
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
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
