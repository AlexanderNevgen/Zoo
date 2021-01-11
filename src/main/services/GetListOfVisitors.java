package services;

import dbConnection.DBConnection;
import lombok.SneakyThrows;
import model.Visitor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class GetListOfVisitors {

    static LinkedList<Visitor> visitorList = new LinkedList<Visitor>();

    @SneakyThrows(Exception.class)
    public static LinkedList<Visitor> getALLVisitors() {

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
