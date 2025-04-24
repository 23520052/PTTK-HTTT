
public class Sach {
    private String maSach, tenSach, tacGia, nxb;
    private double gia;

    // Constructor
    public Sach(String maSach, String tenSach, String tacGia, String nxb, double gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nxb = nxb;
        this.gia = gia >= 0 ? gia : 0; // Kiểm tra giá hợp lệ
    }
    
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        if (gia >= 0) {
            this.gia = gia;
        } else {
            throw new IllegalArgumentException("Gia khong the la so am");
        }
    }
    
    // Override toString for easy printing
    @Override
    public String toString() {
        return "Sách [Mã sách=" + maSach + ", Tên sách=" + tenSach + ", Tác giả=" + tacGia + ", NXB=" + nxb + ", Giá=" + gia + "]";
    }

    // Override equals and hashCode for better object comparison and usage in collections
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sach sach = (Sach) obj;
        return maSach != null && maSach.equals(sach.maSach);
    }

    @Override
    public int hashCode() {
        return maSach != null ? maSach.hashCode() : 0;
    }
}
