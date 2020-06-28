package ai.biomind.cdss.util;


import ai.biomind.cdss.domain.MyDatabase;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public final class DBUtil {

    private DBUtil() {
    }

    private static HikariDataSource dataSource = new HikariDataSource();
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public static Boolean test(MyDatabase mdb) {
        toHikariDataSource(mdb);
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            return conn.isValid(1000);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static List<String> showTables(MyDatabase mdb) {
        jdbcTemplate.setDataSource(toHikariDataSource(mdb));
        return jdbcTemplate.queryForList("show tables", String.class);
    }

    private static HikariDataSource toHikariDataSource(MyDatabase mdb) {
        dataSource.setJdbcUrl(mdb.getUrl());
        dataSource.setUsername(mdb.getUsername());
        dataSource.setPassword(mdb.getPassword());
        dataSource.setDriverClassName(mdb.getDriverClassName());
        return dataSource;
    }

    public static <T> List<T> execute(MyDatabase mdb, String sql, Class<T> clazz) {
        jdbcTemplate.setDataSource(toHikariDataSource(mdb));
        return jdbcTemplate.queryForList(sql, clazz);
    }
}
