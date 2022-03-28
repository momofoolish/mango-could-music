package com.jwss.test;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.ejlchina.okhttps.HTTP;
import com.jwss.music.enums.DeleteMusicType;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jwss
 */
public class JunitTest {
    private static final Log logger = LogFactory.get();

    public static void main(String[] args) {
        // HTTP http = HTTP.builder()
        //         .baseUrl("https://www.baidu.com")
        //         .build();
        // logger.info(http.sync("/").get().getBody().toString());

        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:./data/sample.db");
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from person");
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}
