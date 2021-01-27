package main.dbConnection;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private final static Logger log = Logger.getLogger(DBConnection.class);

    private static final String pathDBProp = "E:\\Zoo\\database.properties";
    static String url;
    static String username;
    static String password;
    static Connection conn;

    public static Connection getConnection() {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(pathDBProp))) {
            props.load(in);
            Class.forName(props.getProperty("driver"));
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (IOException | ClassNotFoundException | SQLException e){

            log.error(e.getMessage());
        }
        return conn;
    }
}
