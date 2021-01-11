package services;

import lombok.SneakyThrows;
import model.Visitor;
import dbConnection.DBConnection;

import java.sql.*;

public class AddVisitor {

    @SneakyThrows(Exception.class)
    public static void addVisitor (Visitor visitor){

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
}
