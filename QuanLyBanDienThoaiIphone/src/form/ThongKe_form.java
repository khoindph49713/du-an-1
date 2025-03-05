/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package form;

import entity.ThongKe;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import repository.ThongKe_Repository;
import response.ThongKe_Response;

/**
 *
 * @author Nguyen duoc
 */
public class ThongKe_form extends javax.swing.JInternalFrame {
    ArrayList<ThongKe_Response> List = new ArrayList<>();
    ThongKe_Repository repo_ThongKe = new ThongKe_Repository(); 
    DefaultTableModel model_TKSanPham = new DefaultTableModel();
     DefaultTableModel model_TKDoanhThu = new DefaultTableModel();
    public ThongKe_form() {
        initComponents();
        cauHinh_form();
        fillTongDoanhThu(repo_ThongKe.getAll_ThongKe());
        List = repo_ThongKe.getAll_ChiTietSanPham();
        model_TKSanPham = (DefaultTableModel) tbTKSanPham.getModel();
        model_TKDoanhThu = (DefaultTableModel) tbTKDT.getModel();
        fillChiTietSanPham(repo_ThongKe.getAll_ChiTietSanPham());
        fillThongKeTable(repo_ThongKe.getALL_ThongKeTable());
        fillDoanhThuHomNay(repo_ThongKe.getALL_TongDoanhThuHomNay());
        fillSoHoaDon(repo_ThongKe.getThongKe_HoaDon());
      
    
    }
    public void fillTongDoanhThu(ArrayList<ThongKe_Response> list ){
        
        ThongKe_Response t = list.get(0); 
        lbTongDoanhThu.setText(t.getTongDoanhThu()+"");
    }
    
    public void fillDoanhThuHomNay(ArrayList<ThongKe_Response> list){
        ThongKe_Response tkhn = list.get(0);
    }
    
    public void fillSoHoaDon(ArrayList<ThongKe_Response> list){
        ThongKe_Response tkhd = list.get(0);
        lbSoHoaDon.setText(tkhd.getSoHoaDonDaDuocThanhToan()+"");
    }
    public void fillSoHoaDonHomNay(ArrayList<ThongKe_Response> list){
        ThongKe_Response tkhdn = list.get(0);
        lbSoHoaDon.setText(tkhdn.getSoHoaDonDaDuocThanhToanHomNay()+"");
    }
    public void fillChiTietSanPham(ArrayList<ThongKe_Response> list){
        model_TKSanPham.setRowCount(0);
        for (ThongKe_Response CTSP : list){
            model_TKSanPham.addRow(new Object[]{
                CTSP.getMaSanPham(), CTSP.getTenSanPham(), CTSP.getSoLuongSanPham(), CTSP.getDoanhthusanpham()
            });
        }
    }
    public void fillThongKeTable(ArrayList<ThongKe_Response> list){
        model_TKDoanhThu.setRowCount(0);
        for (ThongKe_Response TKSP : list){
            model_TKDoanhThu.addRow(new Object[]{
               TKSP.getSanPhamBan(), TKSP.getNgayThanhToan(),TKSP.getSoLuong(), TKSP.getTongGiaBan(), TKSP.getTongGiaGiam(), TKSP.getTongDoanhThu2()
            });
        }
    }
    public void fillThongKeTableHomNay(ArrayList<ThongKe_Response> list){
        DefaultTableModel model = (DefaultTableModel) tbTKDT.getModel();
    model.setRowCount(0); // Clear existing rows

    for (ThongKe_Response tk : list) {
        Object[] row = new Object[]{
            tk.getSanPhamBan(),
            tk.getNgayThanhToan(),
            tk.getSoLuong(),
            tk.getTongGiaBan(),
            tk.getTongGiaGiam(),
            tk.getTongDoanhThu2()
        };
        model.addRow(row);
    }
    }
    public void fillThongKeTableDate(ArrayList<ThongKe_Response> list){
        model_TKDoanhThu.setRowCount(0);
        for (ThongKe_Response tk : list){
            model_TKDoanhThu.addRow(new Object[]{
                tk.getSanPhamBan(),
                tk.getNgayThanhToan(),
                tk.getSoLuong(),
                tk.getTongGiaBan(),
                tk.getTongGiaGiam(),
                tk.getTongDoanhThu2(),
            });
        }
    }
    public void fillThongKeTheoNgay(ArrayList<ThongKe_Response> list){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbTONGDOANHTHU = new javax.swing.JLabel();
        lbTongDoanhThu = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbSOHOADON = new javax.swing.JLabel();
        lbSoHoaDon = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        DoanhThuTab = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTKSanPham = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTKDT = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbLoaiThoiGian = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbDateNBD = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cbNgayKT = new com.toedter.calendar.JDateChooser();
        btLoc = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(273, 107));

        lbTONGDOANHTHU.setText("Tổng Số Doanh Thu");

        lbTongDoanhThu.setText("$$$");

        jLabel15.setText("VND");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Coins.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTONGDOANHTHU)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTongDoanhThu)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTONGDOANHTHU)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lbTongDoanhThu))
                        .addGap(9, 9, 9)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 255, 204));
        jPanel5.setPreferredSize(new java.awt.Dimension(273, 107));

        lbSOHOADON.setText("Số Hóa Đơn Đã Được Thanh Toán");

        lbSoHoaDon.setText("$$$");

        jLabel13.setText("Hóa Đơn");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Unordered list.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSOHOADON)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbSoHoaDon)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbSOHOADON)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSoHoaDon)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jButton1.setText("Báo Cáo");

        DoanhThuTab.setBackground(new java.awt.Color(0, 204, 204));

        jPanel6.setBackground(new java.awt.Color(0, 255, 204));

        tbTKSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Doanh Thu"
            }
        ));
        tbTKSanPham.setPreferredSize(new java.awt.Dimension(300, 120));
        tbTKSanPham.setRowHeight(30);
        jScrollPane1.setViewportView(tbTKSanPham);

        jLabel11.setText("Top 5 Sản Phẩm Bán Chạy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(401, 401, 401))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        DoanhThuTab.addTab("Sản Phẩm", jPanel6);

        jPanel7.setBackground(new java.awt.Color(0, 204, 153));

        tbTKDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sản Phẩm Bán", "Ngày Thanh Toán", "Số Lượng", "Tổng Giá Bán", "Tổng Giá Giảm", "Doanh Thu"
            }
        ));
        tbTKDT.setRowHeight(30);
        jScrollPane2.setViewportView(tbTKDT);

        jPanel9.setBackground(new java.awt.Color(0, 255, 255));

        jLabel9.setText("Năm");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm 2022", "Năm 2023", "Năm 2024" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox3, 0, 201, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Chi Tiết Doanh Thu");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        DoanhThuTab.addTab("Doanh Thu", jPanel7);

        jLabel1.setText("Loại Thời Gian");

        cbLoaiThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổng Tất Cả", "Hôm Nay", "Theo Ngày" }));
        cbLoaiThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiThoiGianActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày Bắt Đầu");

        cbDateNBD.setDateFormatString("dd-MM-yyyy");

        jLabel6.setText("Ngày Kết Thúc");

        cbNgayKT.setDateFormatString("dd-MM-yyyy");

        btLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Zoom.png"))); // NOI18N
        btLoc.setText("Lọc");
        btLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DoanhThuTab, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(98, 98, 98)
                                            .addComponent(cbDateNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(120, 120, 120)
                                    .addComponent(btLoc)
                                    .addGap(87, 87, 87))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addComponent(cbDateNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cbNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btLoc))
                .addGap(140, 140, 140)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DoanhThuTab, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocActionPerformed
        // TODO add your handling code here:
       String selectedTimePeriod = cbLoaiThoiGian.getSelectedItem().toString();

    ArrayList<ThongKe_Response> filteredList = new ArrayList<>();
    
     

    if ("Hôm Nay".equals(selectedTimePeriod)) {
        filteredList = repo_ThongKe.getALL_ThongKeTableUpdateNow();
        lbSOHOADON.setText("Số Hóa Đơn Ngày Hôm Nay");
        lbSoHoaDon.setText(repo_ThongKe.getALL_ThongKeHoaDonNow().get(0).getSoHoaDonDaDuocThanhToanHomNay()+"");
        lbTONGDOANHTHU.setText("Doanh Thu Ngày Hôm Nay");
        lbTongDoanhThu.setText(repo_ThongKe.getALL_TongDoanhThuHomNay().get(0).getTongDoanhThuHomNay()+"");
        // Check if the list is empty and show a message if it is
        if (filteredList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hôm nay không có doanh thu vì không bán được hàng.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            fillThongKeTableHomNay(filteredList);
}
            fillThongKeTableHomNay(filteredList);
        } else if ("Tổng Tất Cả".equals(selectedTimePeriod)) {
        lbSOHOADON.setText("Tổng Số Hóa Đơn");
        lbSoHoaDon.setText(repo_ThongKe.getThongKe_HoaDon().get(0).getSoHoaDonDaDuocThanhToan()+"");
        lbTONGDOANHTHU.setText("Tổng Doanh Thu");
        lbTongDoanhThu.setText(repo_ThongKe.getAll_ThongKe().get(0).getTongDoanhThu()+"");
        fillThongKeTable(repo_ThongKe.getALL_ThongKeTable());
            // Fill the table with the filtered data
            
        }else if ("Theo Ngày".equals(selectedTimePeriod)){
                  fillThongKeTable(repo_ThongKe.getALL_ThongKeTableDate(cbDateNBD.getDate(),cbNgayKT.getDate()));
                  lbTONGDOANHTHU.setText("Doanh Thu Theo Khoảng Ngày");
                  lbTongDoanhThu.setText(repo_ThongKe.getALL_ThongKeTongDoanhThuDate(cbDateNBD.getDate(), cbNgayKT.getDate()).get(0).getTongDoanhThuDate()+"");
                  lbSOHOADON.setText("Số Hóa Đơn Theo Khoảng Ngày");
                  lbSoHoaDon.setText(repo_ThongKe.getALL_ThongKeHoaDonDate(cbDateNBD.getDate(),cbNgayKT.getDate()).get(0).getTongHoaDonDate()+"");
        }
    }//GEN-LAST:event_btLocActionPerformed

    private void cbLoaiThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiThoiGianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiThoiGianActionPerformed

    public void cauHinh_form(){
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane DoanhThuTab;
    private javax.swing.JButton btLoc;
    private com.toedter.calendar.JDateChooser cbDateNBD;
    private javax.swing.JComboBox<String> cbLoaiThoiGian;
    private com.toedter.calendar.JDateChooser cbNgayKT;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbSOHOADON;
    private javax.swing.JLabel lbSoHoaDon;
    private javax.swing.JLabel lbTONGDOANHTHU;
    private javax.swing.JLabel lbTongDoanhThu;
    private javax.swing.JTable tbTKDT;
    private javax.swing.JTable tbTKSanPham;
    // End of variables declaration//GEN-END:variables
}
