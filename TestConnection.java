import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            System.out.println("Ket noi thanh cong!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Ket noi that bai!");
            e.printStackTrace();
        }
    }
}

