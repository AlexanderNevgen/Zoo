package repository;

import dbConnection.*;
import model.Ticket;
import model.Visitor;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class TicketDao {

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
        for(int i=0;i<visitor.getTicketCount();i++) {
            String query = "INSERT ticket(date, idvisitor) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, idvisitor);
            preparedStatement.executeUpdate();
        }
    }

    public static void updateTicket(Visitor visitor, int id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        String query = "DELETE FROM ticket WHERE idvisitor = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

        Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        for (int i = 0; i < visitor.getTicketCount(); i++) {
            query = "INSERT ticket(date, idvisitor) VALUES (?, ?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        }

    }
    public static void deleteTicket(int id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        String query ="DELETE FROM ticket WHERE idvisitor = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    public List<Ticket> findTicketById(int idVisitor) throws SQLException, IOException, ClassNotFoundException {
        Visitor.ticketList.clear();
        Connection conn = DBConnection.getConnection();

        String query ="SELECT * FROM TICKET WHERE idvisitor = ?;";
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
}
