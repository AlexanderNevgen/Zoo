package main.repository;

import main.dbConnection.*;
import main.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public interface VisitorDao extends JpaRepository<Visitor, Integer> {


     /*static void update(Visitor visitor) throws SQLException {
        Connection conn = DBConnection.getConnection();

        String query = "UPDATE visitors SET  firstName = ?, lastName = ?, age = ? WHERE id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.setString(2, visitor.getLastName());
        preparedStatement.setInt(3, visitor.getAge());
        preparedStatement.setInt(4, visitor.getId());
        preparedStatement.executeUpdate();

        TicketDao.updateTicket(visitor);
    }*/


    @Modifying
    @Query("UPDATE visitors SET firstName = :firstName, lastName = :lastname")
    void updateVisitor();

    List<Visitor> findVisitorByFirstNameAndLastName(String firstName, String lastName);
}
