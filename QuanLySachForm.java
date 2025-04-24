
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.KeyEvent;

public class QuanLySachForm extends javax.swing.JFrame {

    SachDAO dao = new SachDAO();
    
    public QuanLySachForm() {
        initComponents();
        setupUI();
        hienThiDanhSach(); // Load dữ liệu khi mở form
        
        // Gán phím tắt F5 cho nút Làm mới
        btLamMoi.setMnemonic(KeyEvent.VK_F5);
    }
    
    private void setupUI() { 
        // Set up frame
        setTitle("Quản Lý Sách");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set background color to black
        getContentPane().setBackground(new Color(0, 0, 50));
        
        Them.setBackground(new Color(0, 0, 50));
        Them.setForeground(Color.WHITE);
        Them.setBorder(new LineBorder(Color.GRAY, 2, true));  // Rounded border
        
        Xoa.setBackground(new Color(0, 0, 50));
        Xoa.setForeground(Color.WHITE);
        Xoa.setBorder(new LineBorder(Color.GRAY, 2, true));  // Rounded border
        
        Sua.setBackground(new Color(0, 0, 50));
        Sua.setForeground(Color.WHITE);
        Sua.setBorder(new LineBorder(Color.GRAY, 2, true));  // Rounded border
        
        TimKiem.setBackground(new Color(0, 0, 50));
        TimKiem.setForeground(Color.WHITE);
        TimKiem.setBorder(new LineBorder(Color.GRAY, 2, true));  // Rounded border
        
        add(Them);
        add(Xoa);
        add(Sua);
        add(TimKiem);
        
        // Add mouse listener for hover effect
        Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Them.setBackground(new Color(255, 102, 102));  // Khi hover vào nút
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Them.setBackground(new Color(0, 0, 50));  // Màu khi không hover
            }
        });
            Sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Sua.setBackground(new Color(255, 102, 102));  // Khi hover vào nút
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Sua.setBackground(new Color(0, 0, 50));  // Màu khi không hover
            }
        });

        Xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Xoa.setBackground(new Color(255, 102, 102));  // Khi hover vào nút
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Xoa.setBackground(new Color(0, 0, 50));  // Màu khi không hover
            }
        });

        TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TimKiem.setBackground(new Color(255, 102, 102));  // Khi hover vào nút
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TimKiem.setBackground(new Color(0, 0, 50));  // Màu khi không hover
            }
        });
        
        // Set visibility
        setVisible(true);
       
            // Set up labels and text fields
        lbMaSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaSach.setText("Mã sách");
        lbMaSach.setForeground(Color.WHITE);
        lbTenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTenSach.setText("Tên sách ");
        lbTenSach.setForeground(Color.WHITE);
        lbTacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTacGia.setText("Tác giả");
        lbTacGia.setForeground(Color.WHITE);
        lbNXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNXB.setText("NXB");
        lbNXB.setForeground(Color.WHITE);
        lbGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbGia.setText("Giá");
        lbGia.setForeground(Color.WHITE);

        // Set TextField styles
        txtMaSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        // Create layout with GroupLayout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenSach)
                            .addComponent(lbTacGia)
                            .addComponent(lbNXB)
                            .addComponent(lbGia)
                            .addComponent(lbMaSach))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(Them)
                        .addGap(18, 18, 18)
                        .addComponent(Sua)
                        .addGap(18, 18, 18)
                        .addComponent(Xoa)
                        .addGap(18, 18, 18)
                        .addComponent(TimKiem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(417, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMaSach)
                        .addGap(18, 18, 18)
                        .addComponent(lbTenSach)
                        .addGap(18, 18, 18)
                        .addComponent(lbTacGia)
                        .addGap(15, 15, 15)
                        .addComponent(lbNXB)
                        .addGap(18, 18, 18)
                        .addComponent(lbGia))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Them)
                    .addComponent(Sua)
                    .addComponent(Xoa)
                    .addComponent(TimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );

        pack();
        
    }
   
    private void hienThiDanhSach() {
        // Xoá dữ liệu cũ
        DefaultTableModel model = (DefaultTableModel) tableSach.getModel();
        model.setRowCount(0); // 

        // Lấy dữ liệu từ CSDL
        List<Sach> ds = dao.getAllSachs();

        // Đổ dữ liệu vào bảng
        for (Sach s : ds) {
            Object[] row = {
                s.getMaSach(),
                s.getTenSach(),
                s.getTacGia(),
                s.getNxb(),
                s.getGia()
            };
            model.addRow(row);
        }
    }
    
    private void hienThiDanhSach(List<Sach> ds) {
        DefaultTableModel model = (DefaultTableModel) tableSach.getModel();
        model.setRowCount(0); // Xoá dữ liệu cũ

        for (Sach s : ds) {
            Object[] row = {
                s.getMaSach(),
                s.getTenSach(),
                s.getTacGia(),
                s.getNxb(),
                s.getGia()
            };
            model.addRow(row);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Them = new javax.swing.JButton();
        txtMaSach = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSach = new javax.swing.JTable();
        Sua = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        TimKiem = new javax.swing.JButton();
        txtTenSach = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        lbMaSach = new javax.swing.JLabel();
        lbTenSach = new javax.swing.JLabel();
        lbTacGia = new javax.swing.JLabel();
        lbNXB = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        btLamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Them.setText("Thêm ");
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        tableSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Tác giả", "NXB", "Giá "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSach.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                tableSachAncestorRemoved(evt);
            }
        });
        jScrollPane1.setViewportView(tableSach);

        Sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Sua.setText("Sửa ");
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        Xoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Xoa.setText("Xóa");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        TimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TimKiem.setText("Tìm kiếm");
        TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemActionPerformed(evt);
            }
        });

        txtNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNXBActionPerformed(evt);
            }
        });

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        lbMaSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaSach.setText("Mã sách");

        lbTenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTenSach.setText("Tên sách ");

        lbTacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTacGia.setText("Tác giả");

        lbNXB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNXB.setText("NXB");

        lbGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbGia.setText("Giá");

        btLamMoi.setText("Làm mới ");
        btLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenSach)
                            .addComponent(lbTacGia)
                            .addComponent(lbNXB)
                            .addComponent(lbGia)
                            .addComponent(lbMaSach))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(Them)
                        .addGap(18, 18, 18)
                        .addComponent(Sua)
                        .addGap(18, 18, 18)
                        .addComponent(Xoa)
                        .addGap(18, 18, 18)
                        .addComponent(TimKiem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMaSach)
                        .addGap(18, 18, 18)
                        .addComponent(lbTenSach)
                        .addGap(18, 18, 18)
                        .addComponent(lbTacGia)
                        .addGap(15, 15, 15)
                        .addComponent(lbNXB)
                        .addGap(18, 18, 18)
                        .addComponent(lbGia))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Them)
                    .addComponent(Sua)
                    .addComponent(Xoa)
                    .addComponent(TimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLamMoi)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemActionPerformed
        String keyword = JOptionPane.showInputDialog(this, "Nhập tên sách cần tìm:");// tìm theo tên
        if (keyword != null && !keyword.isEmpty()) {
            List<Sach> ds = dao.timKiemSach(keyword);
            if (ds.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách nào!");
            } else {
            hienThiDanhSach(ds);
            }
    }//GEN-LAST:event_TimKiemActionPerformed
    }
    
    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void txtNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNXBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNXBActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        String ma = txtMaSach.getText();
        String ten = txtTenSach.getText();
        String tacGia = txtTacGia.getText();
        String nxb = txtNXB.getText();
        double gia;
        
        
        if (ma.isEmpty() || ten.isEmpty() || tacGia.isEmpty() || nxb.isEmpty() || txtGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return;
        }
        
        try {
            gia = Double.parseDouble(txtGia.getText());
            if (gia < 0) {
                JOptionPane.showMessageDialog(this, "Gia phai lon hon hoac bang 0");
                return;
            }
            // Tiếp tục xử lý nếu giá hợp lệ
        } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Gia phai la so hop le!");
                return;
        }
        
        Sach sach = new Sach(ma, ten, tacGia, nxb, gia);
        if (dao.themSach(sach)){
            JOptionPane.showMessageDialog(this, "Them thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "Them that bai");
        }
        
        hienThiDanhSach(); 
    }//GEN-LAST:event_ThemActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        String ma = txtMaSach.getText();
        String ten = txtTenSach.getText();
        String tacGia = txtTacGia.getText();
        String nxb = txtNXB.getText();
        double gia = Double.parseDouble(txtGia.getText());
        
        if (ma.isEmpty() || ten.isEmpty() || tacGia.isEmpty() || nxb.isEmpty() || txtGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return;
        }
        
        Sach sach = new Sach(ma, ten, tacGia, nxb, gia);
        if (dao.suaSach(sach) ){
            JOptionPane.showMessageDialog(this, "Sua thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "Sua that bai");
        }
        
        hienThiDanhSach();
    }//GEN-LAST:event_SuaActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        String ma = txtMaSach.getText();
        boolean success = dao.xoaSach(ma);
        
        if (success){
            JOptionPane.showMessageDialog(this, "Xoa thanh cong");
        } else {
            JOptionPane.showMessageDialog(this, "Xoa that bai");
        }
        
        hienThiDanhSach();
    }//GEN-LAST:event_XoaActionPerformed

    private void tableSachAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tableSachAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSachAncestorRemoved

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        hienThiDanhSach(); // Tải lại dữ liệu sách từ database
    }//GEN-LAST:event_btLamMoiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLySachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySachForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton TimKiem;
    private javax.swing.JButton Xoa;
    private javax.swing.JButton btLamMoi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbMaSach;
    private javax.swing.JLabel lbNXB;
    private javax.swing.JLabel lbTacGia;
    private javax.swing.JLabel lbTenSach;
    private javax.swing.JTable tableSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
