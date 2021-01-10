package servlets;

import model.Ticket;
import model.Visitor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;

public class DBConnection {

    static LinkedList<Visitor> visitorList = new LinkedList<Visitor>();
    static LinkedList<Ticket> ticketList = new LinkedList<Ticket>();

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("E:\\Zoo\\database.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    public static LinkedList <Visitor> getALLVisitors() {
        try {
            visitorList.clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = getConnection()) {

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM visitors ");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    visitorList.add(new Visitor(name, id));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return visitorList;
    }

    public static void addVisitor(String name, int ticketCount) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = getConnection()) {

                Statement statement = conn.createStatement();

                String query = "INSERT visitors(name) VALUES (?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();

                ResultSet resultSet = statement.executeQuery("SELECT idvisitor FROM visitors  \n" +
                        "ORDER BY idvisitor DESC  \n" +
                        "LIMIT 1;");

                int idvisitor = 0;
                while (resultSet.next()) {

                    idvisitor = resultSet.getInt(1);
                }

                Date sqlDate = new java.sql.Date(System.currentTimeMillis());
                for (int i = 0; i < ticketCount; i++) {
                    query = "INSERT ticket(date, idvisitor) VALUES (?, ?)";
                    preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setDate(1, sqlDate);
                    preparedStatement.setInt(2, idvisitor);
                    preparedStatement.executeUpdate();

                }
            }
        } catch (Exception ex) {

            System.out.println(ex);
        }
    }

    public static void deleteVisitor(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = getConnection()) {

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
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void updateVisitor(int id, String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = getConnection()) {

                Statement statement = conn.createStatement();
                String query ="UPDATE visitors SET  name = ? WHERE idvisitor = ?;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(2, id);
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static LinkedList<Ticket> findTicketById (int idVisitor){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = getConnection()) {

                Statement statement = conn.createStatement();
                String query ="SELECT * FROM TICKET WHERE idvisitor = ?;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, idVisitor);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idTicket = resultSet.getInt(1);
                    Date date = resultSet.getDate(2);
                    ticketList.add(new Ticket(date, idTicket, idVisitor));
                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ticketList;
    }
}
