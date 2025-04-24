import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
            return null;
        }

        String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // Đảm bảo SID là đúng (orcl hoặc xe tùy máy)
        String user = "c##myuser"; // Thay bằng user thực tế bạn tạo
        String password = "password"; // Thay bằng mật khẩu thực tế

        return DriverManager.getConnection(url, user, password);
    }
}