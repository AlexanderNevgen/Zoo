package services;

import dbConnection.DBConnection;
import lombok.SneakyThrows;
import model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;

public class FindTicketById {

    static LinkedList<Ticket> ticketList = new LinkedList<Ticket>();

    @SneakyThrows(Exception.class)
    public static LinkedList<Ticket> findTicketById (int idVisitor){
        ticketList.clear();
        Connection conn = DBConnection.getConnection();

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
        return ticketList;
    }
}
