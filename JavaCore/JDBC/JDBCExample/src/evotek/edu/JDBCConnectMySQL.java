package evotek.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCConnectMySQL {
  // Thông tin kết nối
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/cd";
  static final String USER = "root";
  static final String PASS = "Quanghaibka1597"; // Thay 'password' bằng mật khẩu thực tế của bạn

  public static void main(String[] args) {
    Connection conn = null;

    try {
      // Đăng ký JDBC Driver
      Class.forName(JDBC_DRIVER);

      // Mở kết nối
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      if (conn != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to make connection!");
      }

    } catch (SQLException se) {
      // Xử lý lỗi JDBC
      se.printStackTrace();
    } catch (Exception e) {
      // Xử lý lỗi Class.forName
      e.printStackTrace();
    } finally {
      // Đóng kết nối
      try {
        if (conn != null) conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }

    System.out.println("Goodbye!");
  }

}
