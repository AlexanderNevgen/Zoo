package main.dbConnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String pathDBProp = "E:\\Zoo\\database.properties";

    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(pathDBProp))) {
            props.load(in);
        }
        Class.forName(props.getProperty("driver"));
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
