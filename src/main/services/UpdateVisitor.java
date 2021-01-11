package services;

import dbConnection.DBConnection;
import lombok.SneakyThrows;
import model.Visitor;

import java.sql.*;

public class UpdateVisitor {

    @SneakyThrows(Exception.class)
    public static void updateVisitor(Visitor visitor, int id) {
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
}
