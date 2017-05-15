package db;

import java.sql.*;

/**
 * Created by Administrator on 2017/5/14.
 */
public class DBhelper {
//    String driver = "com.mysql.jdbc.Driver";
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/excel_test?useUnicode=true&characterEncoding=utf-8";

    Connection con = null;
    ResultSet res = null;

    public void DataBase() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "1234");
        } catch (ClassNotFoundException e) {
            System.err.println("装载 JDBC/ODBC 驱动程序失败。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("无法连接数据库");
            e.printStackTrace();
        }
    }

    //查询数据库
    public ResultSet Search(String sql, String str[]) {
        DataBase();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            res = pst.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    // 增删修改
    public int AddU(String sql, String str[]) {
        int a = 0;
        DataBase();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            System.out.println(str);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            System.out.println(pst);
            a = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }


}
