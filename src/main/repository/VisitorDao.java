package repository;

import dbConnection.*;
import model.Visitor;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;

public class VisitorDao {

    static LinkedList<Visitor> visitorList = new LinkedList<Visitor>();

    public void save(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        String query = "INSERT visitors(name) VALUES (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.executeUpdate();

        TicketDao.saveTicket(visitor);

    }

    public void update(Visitor visitor, int id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        String query = "UPDATE visitors SET  name = ? WHERE id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();

        TicketDao.updateTicket(visitor, id);
    }

    public void delete(int id) throws SQLException, IOException, ClassNotFoundException {

            Connection conn = DBConnection.getConnection() ;

            String query ="DELETE FROM visitors WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            TicketDao.deleteTicket(id);

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
