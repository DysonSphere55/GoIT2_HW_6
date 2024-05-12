package goit.database;

import goit.pojo.*;
import goit.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private final Connection connection;
    private final Prefs prefs;

    public DatabaseQueryService(Connection connection) {
        this.connection = connection;
        prefs = new Prefs();
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        String fileName = prefs.getValue(Prefs.FIND_LONGEST_PROJECT_QUERY_FILE);
        try {
            String sqlQuery = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(sqlQuery)) {
                    while (rs.next()) {
                        result.add(new LongestProject(
                                rs.getString("name"),
                                rs.getInt("month_count")));
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String fileName = prefs.getValue(Prefs.FIND_MAX_SALARY_WORKER_QUERY_FILE);
        try {
            String sqlQuery = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(sqlQuery)) {
                    while (rs.next()) {
                        result.add(new MaxSalaryWorker(
                                rs.getString("name"),
                                rs.getLong("salary")));
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() {
        List<MaxProjectsClient> result = new ArrayList<>();
        String fileName = prefs.getValue(Prefs.FIND_MAX_PROJECTS_CLIENT_QUERY_FILE);
        try {
            String sqlQuery = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(sqlQuery)) {
                    while (rs.next()) {
                        result.add(new MaxProjectsClient(
                                rs.getString("name"),
                                rs.getInt("count_project")));
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<EldestWorker> findEldestWorker() {
        List<EldestWorker> result = new ArrayList<>();
        String fileName = prefs.getValue(Prefs.FIND_YOUNGEST_ELDEST_WORKER_QUERY_FILE);
        try {
            String sqlQuery = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(sqlQuery)) {
                    while (rs.next()) {
                        if (rs.getString("type").equals("Eldest")) {
                            result.add(new EldestWorker(
                                    rs.getString("type"),
                                    rs.getString("name"),
                                    LocalDate.parse(rs.getString("birthday"))));
                        }
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<YoungestWorker> findYoungestWorker() {
        List<YoungestWorker> result = new ArrayList<>();
        String fileName = prefs.getValue(Prefs.FIND_YOUNGEST_ELDEST_WORKER_QUERY_FILE);
        try {
            String sqlQuery = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(sqlQuery)) {
                    while (rs.next()) {
                        if (rs.getString("type").equals("Youngest")) {
                            result.add(new YoungestWorker(
                                    rs.getString("type"),
                                    rs.getString("name"),
                                    LocalDate.parse(rs.getString("birthday"))));
                        }
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<ProjectPrice> getProjectPrices() {
        List<ProjectPrice> result = new ArrayList<>();
        String fileName = prefs.getValue(Prefs.GET_PROJECT_PRICE_QUERY_FILE);
        try {
            String sqlQuery = String.join("\n", Files.readAllLines(Paths.get(fileName)));
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(sqlQuery)) {
                    while (rs.next()) {
                        result.add(new ProjectPrice(
                                rs.getString("name"),
                                rs.getLong("price")
                        ));
                    }
                }
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
