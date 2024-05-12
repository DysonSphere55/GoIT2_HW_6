package goit.database;

import goit.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    private final Connection connection;
    private final String sqlUpdate;

    public DatabaseInitService(Connection connection) {
        this.connection = connection;
        String fileName = new Prefs().getValue(Prefs.INIT_DB_FILE);
        try {
            sqlUpdate = String.join("\n", Files.readAllLines(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection connection = Database.getConnection();
        DatabaseInitService dbInitService = new DatabaseInitService(connection);
        dbInitService.initialize();
    }
}
