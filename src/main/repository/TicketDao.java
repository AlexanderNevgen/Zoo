package main.repository;

import main.dbConnection.*;
import main.model.Ticket;
import main.model.Visitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer> {


    /*static void updateTicket(Visitor visitor) throws SQLException{
        Connection conn = DBConnection.getConnection();

        String query = "DELETE FROM ticket WHERE idvisitor = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, visitor.getId());
        preparedStatement.executeUpdate();

        Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        for (int i = 0; i < visitor.getTicketCount(); i++) {
            String query2 = "INSERT ticket(date, idvisitor) VALUES (?, ?)";
            PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
            preparedStatement2.setDate(1, sqlDate);
            preparedStatement2.setInt(2, visitor.getId());
            preparedStatement2.executeUpdate();

        }
    }*/

    @Modifying
    @Query
    void updateTicket(Visitor visitor);

    List<Ticket> findTicketByVisitorId(int id);

}
