package org.example.database;

import org.example.model.*;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<LongestProject> findLongestProject() throws SQLException {
        String filePath = "src/sql/find_longest_project.sql";
        StringBuilder sql = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = br.readLine()) != null) {
                sql.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<LongestProject> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                result.add(LongestProject.builder()
                        .id(resultSet.getObject("ID", Integer.class))
                        .monthCount(resultSet.getObject("MONTH_COUNT", Integer.class))
                        .build());

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public List<MaxProjectsClient> findMaxProjectClient() {
        String filePath = "src/sql/find_max_projects_client.sql";
        StringBuilder sql = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = br.readLine()) != null) {
                sql.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<MaxProjectsClient> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                result.add(MaxProjectsClient.builder()
                        .name(resultSet.getString("NAME"))
                        .projectCount(resultSet.getObject("PROJECT_COUNT", Integer.class))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        String filePath = "src/sql/find_max_salary_worker.sql";
        StringBuilder sql = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = br.readLine()) != null) {
                sql.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<MaxSalaryWorker> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                result.add(MaxSalaryWorker.builder()
                        .name(resultSet.getString("NAME"))
                        .birthday(String.valueOf(LocalDate.parse(resultSet.getString("BIRTHDAY"))))
                        .level(resultSet.getString("LEVEL"))
                        .salary(resultSet.getObject("SALARY", Integer.class))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<ProjectPrices> printProjectPrices() {
        String filePath = "src/sql/print_project_prices.sql";
        StringBuilder sql = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = br.readLine()) != null) {
                sql.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<ProjectPrices> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                result.add(ProjectPrices.builder()
                        .id(resultSet.getObject("ID", Integer.class))
                        .price(resultSet.getString("PRICE"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<YoungestAndOldestWorkers> findYoungestAndOldestWorkers() {
        String filePath = "src/sql/find_youngest_eldest_workers.sql";
        StringBuilder sql = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = br.readLine()) != null) {
                sql.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        List<YoungestAndOldestWorkers> result = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                result.add(YoungestAndOldestWorkers.builder()
                        .type(resultSet.getString("TYPE"))
                        .name(resultSet.getString("NAME"))
                        .birthday(String.valueOf(LocalDate.parse(resultSet.getString("BIRTHDAY"))))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
