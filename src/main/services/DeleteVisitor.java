package services;

import dbConnection.DBConnection;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DeleteVisitor {

    @SneakyThrows(Exception.class)
    public static void deleteVisitor(int id) {
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
}
