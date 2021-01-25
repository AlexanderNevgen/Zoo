package main.repository;

import main.dbConnection.*;
import main.dto.TicketDTO;
import main.model.Ticket;
import main.model.Visitor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@Component ("ticketDao")
@ComponentScan("main")
public class TicketDao {

    public static TicketDao createTicketDao() {

        return new TicketDao();
    }



    public static void saveTicket(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = DBConnection.getConnection();

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT id FROM visitors  \n" +
                "ORDER BY id DESC  \n" +
                "LIMIT 1;");

        int idvisitor = 0;
        while (resultSet.next()) {

            idvisitor = resultSet.getInt(1);
        }

        Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        for (int i = 0; i < visitor.getTicketCount(); i++) {
            String query = "INSERT ticket(date, idvisitor) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, idvisitor);
            preparedStatement.executeUpdate();
        }
    }

    public static void updateTicket(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
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
    }

    public static void deleteTicket(int id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        String query = "DELETE FROM ticket WHERE idvisitor = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    public List<Ticket> findTicketByVisitorId(int idVisitor) throws SQLException, IOException, ClassNotFoundException {
        Visitor.ticketList.clear();
        Connection conn = DBConnection.getConnection();

        String query = "SELECT * FROM TICKET WHERE idvisitor = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, idVisitor);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idTicket = resultSet.getInt(1);
            java.util.Date date = resultSet.getDate(2);
            Visitor.ticketList.add(new Ticket(idTicket, date, idVisitor));
        }
        return Visitor.ticketList;
    }

    public List<Ticket> getAllTickets() throws SQLException, IOException, ClassNotFoundException {

        Visitor.ticketList.clear();
        Connection conn = DBConnection.getConnection();

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM ticket ");
        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            Date date = resultSet.getDate(2);
            int visitorId = resultSet.getInt(3);

            Visitor.ticketList.add(new Ticket(id,date, visitorId));
        }

        return Visitor.ticketList;
    }
}
