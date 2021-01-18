package repository;

import dbConnection.DBConnection;
import model.Ticket;
import model.Visitor;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class VisitorDao {

    static LinkedList<Visitor> visitorList = new LinkedList<Visitor>();

    public void save(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        Statement statement = conn.createStatement();

        String query = "INSERT visitors(name) VALUES (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.executeUpdate();

        ResultSet resultSet = statement.executeQuery("SELECT idvisitor FROM visitors  \n" +
                "ORDER BY idvisitor DESC  \n" +
                "LIMIT 1;");

        int idvisitor = 0;
        while (resultSet.next()) {

            idvisitor = resultSet.getInt(1);
        }

        Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        for (int i = 0; i < visitor.getTicketCount(); i++) {
            query = "INSERT ticket(date, idvisitor) VALUES (?, ?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, idvisitor);
            preparedStatement.executeUpdate();

        }
    }

    public void update(Visitor visitor, int id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        Statement statement = conn.createStatement();
        String query = "UPDATE visitors SET  name = ? WHERE idvisitor = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();

        query = "DELETE FROM ticket WHERE idvisitor = ?";
        preparedStatement = conn.prepareStatement(query);
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

    public void delete(int id) throws SQLException, IOException, ClassNotFoundException {

            Connection conn = DBConnection.getConnection() ;

            Statement statement = conn.createStatement();
            String query ="DELETE FROM visitors WHERE idvisitor = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            query ="DELETE FROM ticket WHERE idvisitor = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

    }

    public List<Ticket> findTicketById(int idVisitor) throws SQLException, IOException, ClassNotFoundException {
            Visitor.ticketList.clear();
            Connection conn = DBConnection.getConnection();

            Statement statement = conn.createStatement();
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

    public LinkedList<Visitor> findAll() throws SQLException, IOException, ClassNotFoundException {
        visitorList.clear();
        Connection conn = DBConnection.getConnection();

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM visitors ");
        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            visitorList.add(new Visitor(name, id));
        }

        return visitorList;
    }
}
