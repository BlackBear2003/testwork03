package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JBDCUtils {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String JDBC_URL = "jdbc:mysql://localhost:3306/testwork03?useSSL=false&characterEncoding=utf8";
    static String JDBC_USER = "root";
    static String JDBC_PASSWORD = "wzl348358584";

    /**
     * 获取连接
     *
     */

    public static Connection getConnection(){
        Connection con = null ;
        try {

            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("success");
            con.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con ;

    }


    /**
     * 关闭连接
     */
    public static void free(ResultSet rs, Statement sta , Connection con)
    {
        try {
            if(null != rs)
            {
                rs.close();
                rs = null ;
            }

            if(null != sta)
            {
                sta.close();
                sta = null ;
            }

            if(null != con)
            {
                con.close();
                con = null ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
