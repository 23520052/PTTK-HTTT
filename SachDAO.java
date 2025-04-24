import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SachDAO {
    // Kiểm tra mã sách đã tồn tại chưa
    private boolean isMaSachExist(String maSach) {
        String sql = "SELECT COUNT(*) FROM SACH WHERE MaSach = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maSach);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi kiem tra ma sach: " + e.getMessage());
        }
        return false;
    }
    
    // Kiểm tra giá có âm không
    private boolean isGiaValid(double gia) {
        return gia >= 0;
    }
    public List<Sach> getAllSachs() {
        List<Sach> ds = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM SACH";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ds.add(new Sach(
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getString("TacGia"),
                    rs.getString("NXB"),
                    rs.getDouble("Gia")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi lấy danh sách sách: " + ex.getMessage());
        }
        return ds;
    }
    
    public boolean themSach(Sach sach) {    
        if (isMaSachExist(sach.getMaSach())) {
            JOptionPane.showMessageDialog(null, "Ma sach da ton tai!");
            return false;
        }
        
        if (!isGiaValid(sach.getGia())) {
            JOptionPane.showMessageDialog(null, "Gia khong hop le!");
            return false;
        }
        
        String sql = "INSERT INTO Sach(maSach, tenSach, tacGia, nxb, gia) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sach.getMaSach());
            stmt.setString(2, sach.getTenSach());
            stmt.setString(3, sach.getTacGia());
            stmt.setString(4, sach.getNxb());
            stmt.setDouble(5, sach.getGia());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suaSach(Sach sach) {
        if (!isGiaValid(sach.getGia())) {
            JOptionPane.showMessageDialog(null, "Gia khong hop le!");
            return false;
        }
        
        String sql = "UPDATE SACH SET TenSach=?, TacGia=?, NXB=?, Gia=? WHERE MaSach=?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sach.getTenSach());
            stmt.setString(2, sach.getTacGia());
            stmt.setString(3, sach.getNxb());
            stmt.setDouble(4, sach.getGia());
            stmt.setString(5, sach.getMaSach());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xoá sách theo MaSach
    public boolean xoaSach(String maSach) {
        String sql = "DELETE FROM SACH WHERE MaSach=?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maSach);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();            
            JOptionPane.showMessageDialog(null, "Loi xoa sach: " + e.getMessage());
        }
        return false;
    }

    // Tìm kiếm theo tên sách (có thể thay đổi thành tìm theo mã nếu muốn)
    public List<Sach> timKiemSach(String keyword) {
        List<Sach> ds = new ArrayList<>();
        String sql = "SELECT * FROM SACH WHERE TenSach LIKE ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ds.add(new Sach(
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getString("TacGia"),
                    rs.getString("NXB"),
                    rs.getDouble("Gia")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Loi tim kiem sach: " + e.getMessage());
        }
        return ds;
    }
  
}
