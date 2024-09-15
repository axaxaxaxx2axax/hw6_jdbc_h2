package org.example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;
import org.h2.Driver;

import java.sql.Connection;
import java.sql.SQLException;


@UtilityClass
public class Database {
    private static final String DB_URL = "jdbc:h2:~/MegaSoft";
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl(DB_URL);
        config.setDriverClassName("org.h2.Driver");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
