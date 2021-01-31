package main.repository;

import main.model.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer> {

    @Modifying
    @Query(
            value = "UPDATE ticket t set t.date = :date where id =: visitorId",
            nativeQuery = true
    )
    void updateTicket(@Param("visitorId") int visitorId);

    List<Ticket> findTicketByVisitorId(int id);
}
