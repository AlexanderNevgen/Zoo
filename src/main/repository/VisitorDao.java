package main.repository;

import main.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class VisitorDao {

    private final TicketDao ticketDao;

    @Autowired
    public VisitorDao(TicketDao ticketDao){
        this.ticketDao = ticketDao;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("visitors");

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    EntityManager em = getEntityManager();

    public Long saveVisitor(Visitor visitor){

        em.getTransaction().begin();
        em.persist(visitor);
        em.getTransaction().commit();
        for(int i=0; i<visitor.getTicketCount(); i++){
            ticketDao.saveTicket(visitor.getId());
        }
        return visitor.getId();
    }

    public Visitor getVisitorById(Long visitorId) {

        Visitor visitor = em.find(Visitor.class, visitorId);
        em.detach(visitor);
        return visitor;
    }

    public List<Visitor> findVisitorByName(String firstName, String lastName) {

        return em.createQuery("SELECT visitor from Visitor visitor where visitor.firstName = ?1 and visitor.lastName = ?2")
                .setParameter(1, firstName).setParameter(2, lastName)
                .getResultList();
    }

    public Long deleteVisitorById(Long visitorId) {
        em.getTransaction().begin();
        Visitor visitor = em.find(Visitor.class, visitorId);
        em.remove(visitor);
        em.getTransaction().commit();
        return visitorId;
    }

    public List<Visitor> getAllVisitors (){

        return em.createQuery("Select visitor from Visitor visitor").getResultList();
    }

    public Long updateVisitor(Visitor visitor) {
        em.detach(visitor);
        visitor.setFirstName(visitor.getFirstName());
        visitor.setLastName(visitor.getLastName());
        visitor.setAge(visitor.getAge());
        em.getTransaction().begin();
        em.merge(visitor);
        em.getTransaction().commit();
        return visitor.getId();
    }
}
