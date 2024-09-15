package org.example;

import org.example.database.Database;
import org.example.database.DatabaseQueryService;
import org.example.model.LongestProject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findLongestProject().forEach(System.out::println);
        databaseQueryService.findMaxProjectClient().forEach(System.out::println);
        databaseQueryService.findMaxSalaryWorker().forEach(System.out::println);
        databaseQueryService.printProjectPrices().forEach(System.out::println);
        databaseQueryService.findYoungestAndOldestWorkers().forEach(System.out::println);
    }
}