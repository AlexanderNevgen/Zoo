package main.repository;

import main.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitorDao extends JpaRepository<Visitor, Integer> {

    @Modifying
    @Query(
            value = "UPDATE visitors v SET v.firstName = :firstName, v.lastName = :lastName, v.age =:age, v.ticketCount = :ticketCount WHERE v.id = :id",
            nativeQuery = true)
    void updateVisitor(@Param("id") int id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("age") int age, @Param("ticketCount") int ticketCount);

    List<Visitor> findVisitorByFirstNameAndLastName(String firstName, String lastName);
}
