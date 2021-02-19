package main.repository;

import main.model.Visitor;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class VisitorDao {

    @PersistenceUnit
    static EntityManager em;

    public void saveVisitor(Visitor visitor){
        em.getTransaction().begin();
        em.persist(visitor);
        em.getTransaction().commit();
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

    public void updateVisitor(Visitor visitor) {
        Visitor uVisitor = em.find(Visitor.class, visitor.getId());
        uVisitor.setFirstName(visitor.getFirstName());
        uVisitor.setLastName(visitor.getLastName());
        uVisitor.setAge(visitor.getAge());
        em.getTransaction().begin();
        em.merge(uVisitor);
        em.flush();
        em.getTransaction().commit();
    }
}
