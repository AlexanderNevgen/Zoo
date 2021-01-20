package main.repository;

import main.dbConnection.*;
import main.model.Visitor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Component ("visitorDao")
@ComponentScan("main")

public class VisitorDao {

    public static VisitorDao createVisitorDao() {

        return new VisitorDao();

    }

    static LinkedList<Visitor> visitorList = new LinkedList<Visitor>();

    public void save(Visitor visitor) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        String query = "INSERT visitors(firstName, lastName, age) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.setString(2, visitor.getLastName());
        preparedStatement.setInt(3, visitor.getAge());
        preparedStatement.executeUpdate();

        TicketDao.saveTicket(visitor);

    }

    public void update(Visitor visitor, int id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();

        String query = "UPDATE visitors SET  firstName = ?, lastName = ?, age = ? WHERE id = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.setString(2, visitor.getLastName());
        preparedStatement.setInt(3, visitor.getAge());
        preparedStatement.setInt(4, id);
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
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            int age = resultSet.getInt(4);
            visitorList.add(new Visitor(firstName,lastName, age, id));
        }

        return visitorList;
    }

    public List<Visitor> findVisitorByName(String firstName, String lastName) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        List<Visitor> visitorList = new LinkedList<>();
        String query = "SELECT * FROM VISITORS WHERE firstName = ? AND lastName = ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            int age = resultSet.getInt(4);
            visitorList.add(new Visitor(firstName, lastName, age, id));
        }

        return visitorList;
    }
}
