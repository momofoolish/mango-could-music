package com.jwss.music.util;

import java.sql.*;

/**
 * sqlite工具
 *
 * @author jwss
 * @date 2022-3-29 21:45:19
 */
public class SqliteUtils {
    private static Connection connection = null;
    private static Statement statement = null;
    private static final String url = "jdbc:sqlite:./data/mev-ml-cache.db";

    /**
     * 获取数据库操作对象
     * @return Statement
     */
    public static Statement getStatement() {
        if (statement != null) {
            return statement;
        } else {
            try {
                connection = DriverManager.getConnection(url);
                statement = connection.createStatement();
                statement.setQueryTimeout(30);
                return statement;
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                return null;
            }
        }
    }

    /**
     * 关闭数据库连接
     */
    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
