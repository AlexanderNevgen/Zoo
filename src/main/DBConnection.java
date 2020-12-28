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

                ResultSet resultSet = statement.executeQuery("SELECT * FROM visitors");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int ticketId = resultSet.getInt(3);
                    visitorList.add(new Visitor(name, id, ticketId));
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return visitorList;
    }

    public static void addVisitor(String name, int ticketId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = getConnection()) {

                Statement statement = conn.createStatement();
                String query ="INSERT visitors(firstname, ticketId) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, ticketId);
                int resultSet = preparedStatement.executeUpdate();
                int rows = statement.executeUpdate("INSERT visitors(firstname, ticketId) VALUES (?, ?)");

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
                String query ="DELETE FROM visitors WHERE Id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, id);
                int resultSet = preparedStatement.executeUpdate();

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void updateVisitor(int id, String name, int ticketId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = getConnection()) {

                Statement statement = conn.createStatement();
                String query ="UPDATE visitors SET  firstname = ?, ticketId = ? WHERE id = ?;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(3, id);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, ticketId);
                int resultSet = preparedStatement.executeUpdate();

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
