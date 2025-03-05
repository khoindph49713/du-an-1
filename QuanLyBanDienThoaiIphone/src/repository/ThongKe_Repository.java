/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import config.DBConnect;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import response.NhanVien_Response;
import response.ThongKe_Response;
/**
 *
 * @author acer
 */
public class ThongKe_Repository {
    public ArrayList<ThongKe_Response> getAll_ThongKe(){
        ArrayList<ThongKe_Response> listTK = new ArrayList<>();
        listTK.clear();
        String sql = """
                     SELECT SUM(Tong_Gia) AS Tong_Doanh_Thu
                     FROM HoaDon
                     WHERE Trang_Thai = 1;
                     """;
        try (Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKe_Response tk = ThongKe_Response.builder()
                        .tongDoanhThu(rs.getInt(1))
                        .build();
                        listTK.add(tk);
           }
            return listTK;
        }catch (Exception e){
                return listTK;
                }
    }
    
    public ArrayList<ThongKe_Response> getThongKe_HoaDon(){
        ArrayList<ThongKe_Response> listHD = new ArrayList<>();
        listHD.clear();
        String sql = """
                     SELECT COUNT(*) AS SoHoaDonDaThanhToan
                     FROM HoaDon
                     WHERE Trang_Thai = 1;
                     """;
        try (Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKe_Response tk = ThongKe_Response.builder()
                        .soHoaDonDaDuocThanhToan(rs.getInt(1))
                        .build();
                        listHD.add(tk);
           }
            return listHD;
        }catch (Exception e){
                return listHD;
                }
    }
    
    public ArrayList<ThongKe_Response> getALL_TongDoanhThuHomNay(){
        ArrayList<ThongKe_Response> listDTN = new ArrayList<>();
        listDTN.clear();
        String sql = """
                     SELECT 
                         SUM(hd.Tong_Gia - 
                             CASE 
                                 WHEN COALESCE(gg.Kieu_Giam, 0) = 0 THEN hd.Tong_Gia * COALESCE(gg.Muc_Giam_Gia, 0) / 100 
                                 WHEN COALESCE(gg.Kieu_Giam, 0) = 1 THEN COALESCE(gg.Muc_Giam_Gia, 0)
                                 ELSE 0 
                             END) AS TongDoanhThuHomNay
                     FROM HoaDon hd
                     LEFT JOIN GiamGia gg ON hd.ID_Giam_Gia = gg.ID_Giam_Gia
                     WHERE hd.Trang_Thai = 1
                       AND CONVERT(date, hd.Ngay_Thanh_Toan) = CONVERT(date, GETDATE());
                     """;
        try (Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKe_Response tk = ThongKe_Response.builder()
                        .tongDoanhThuHomNay(rs.getInt(1))
                        .build();
                        listDTN.add(tk);
           }
            return listDTN;
        }catch (Exception e){
                return listDTN;
                }
    }
    
    public ArrayList<ThongKe_Response> getALL_ThongKeHoaDonNow(){
        ArrayList<ThongKe_Response> listHDN = new ArrayList<>();
        listHDN.clear();
        String sql = """
                     SELECT COUNT(*) AS SoHoaDonDaThanhToanHomNay
                     FROM HoaDon
                     WHERE Trang_Thai = 1
                       AND CONVERT(date, Ngay_Thanh_Toan) = CONVERT(date, GETDATE());
                     """;
        try (Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKe_Response tk = ThongKe_Response.builder()
                        .soHoaDonDaDuocThanhToanHomNay(rs.getInt(1))
                        .build();
                        listHDN.add(tk);
           }
            return listHDN;
        }catch (Exception e){
                return listHDN;
                }
    }
    
    public ArrayList<ThongKe_Response> getAll_ChiTietSanPham(){
        ArrayList<ThongKe_Response> listtSP = new ArrayList<>();
        listtSP.clear();
        String sql = """
                     SELECT TOP 5
                         sp.Ma_San_Pham,
                         sp.Ten_San_Pham,
                         SUM(hdct.So_Luong) AS So_Luong_Ban,
                         SUM(hdct.So_Luong * hdct.Gia) AS Doanh_Thu
                     FROM 
                         HoaDon hd
                     INNER JOIN 
                         HoaDonChiTiet hdct ON hd.ID_Hoa_Don = hdct.ID_Hoa_Don
                     INNER JOIN 
                         SanPham sp ON hdct.ID_San_Pham = sp.ID_San_Pham
                     WHERE 
                         hd.Trang_Thai = 1 -- Chỉ lấy các hóa đơn đã thanh toán
                     GROUP BY 
                         sp.Ma_San_Pham, sp.Ten_San_Pham
                     ORDER BY 
                         So_Luong_Ban DESC;
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKe_Response tk = ThongKe_Response.builder()
                        .maSanPham(rs.getString(1))
                        .tenSanPham(rs.getString(2))
                        .soLuongSanPham(rs.getInt(3))
                        .doanhthusanpham(rs.getInt(4))
                        .build();
                        listtSP.add(tk);
            }
            return listtSP;
        }catch (Exception e){
            return listtSP;
        }
    }
    public ArrayList<ThongKe_Response> getALL_ThongKeTable(){
        ArrayList<ThongKe_Response> listTKT = new ArrayList<>();
        listTKT.clear();
        String sql = """
                     	SELECT 
                            sp.Ten_San_Pham,
                            hd.Ngay_Thanh_Toan,
                            SUM(hdct.So_Luong) AS So_Luong_Ban,
                            SUM(hdct.Gia * hdct.So_Luong) AS Tong_Gia_Ban,
                            SUM(
                                CASE
                                    WHEN gg.Kieu_Giam = 0 THEN 
                                        CASE 
                                            WHEN hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100 > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                            ELSE hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100
                                        END
                                    WHEN gg.Kieu_Giam = 1 THEN 
                                        CASE 
                                            WHEN gg.Muc_Giam_Gia > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                            ELSE gg.Muc_Giam_Gia
                                        END
                                    ELSE 0
                                END
                            ) AS Tong_Gia_Giam,
                            SUM(hdct.Gia * hdct.So_Luong) - SUM(
                                CASE
                                    WHEN gg.Kieu_Giam = 0 THEN 
                                        CASE 
                                            WHEN hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100 > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                            ELSE hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100
                                        END
                                    WHEN gg.Kieu_Giam = 1 THEN 
                                        CASE 
                                            WHEN gg.Muc_Giam_Gia > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                            ELSE gg.Muc_Giam_Gia
                                        END
                                    ELSE 0
                                END
                            ) AS Tong_Doanh_Thu
                        FROM 
                            HoaDon hd
                        INNER JOIN 
                            HoaDonChiTiet hdct ON hd.ID_Hoa_Don = hdct.ID_Hoa_Don
                        INNER JOIN 
                            SanPham sp ON hdct.ID_San_Pham = sp.ID_San_Pham
                        LEFT JOIN 
                            GiamGia gg ON hd.ID_Giam_Gia = gg.ID_Giam_Gia
                        WHERE 
                            hd.Trang_Thai = 1 -- Chỉ lấy các hóa đơn đã thanh toán
                        GROUP BY 
                            sp.Ten_San_Pham,
                            hd.Ngay_Thanh_Toan
                        ORDER BY 
                            sp.Ten_San_Pham,
                            hd.Ngay_Thanh_Toan;
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKe_Response tk = ThongKe_Response.builder()
                        .sanPhamBan(rs.getString(1))
                        .ngayThanhToan(rs.getDate(2))
                        .soLuong(rs.getInt(3))
                        .tongGiaBan(rs.getInt(4))
                        .tongGiaGiam(rs.getInt(5))
                        .tongDoanhThu2(rs.getInt(6))
                        .build();
                        listTKT.add(tk);
            }
            return listTKT;
        }catch (Exception e){
            return listTKT;
        }
    }
    public ArrayList<ThongKe_Response> getALL_ThongKeTableUpdateNow() {
    ArrayList<ThongKe_Response> listTKT = new ArrayList<>();
    listTKT.clear();

    String sql = """
      SELECT 
                        sp.Ten_San_Pham,
                        hd.Ngay_Thanh_Toan,
                        SUM(hdct.So_Luong) AS So_Luong_Ban,
                        SUM(hdct.Gia * hdct.So_Luong) AS Tong_Gia_Ban,
                        SUM(
                            CASE
                                WHEN gg.Kieu_Giam = 0 THEN 
                                    CASE 
                                        WHEN hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100 > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                        ELSE hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100
                                    END
                                WHEN gg.Kieu_Giam = 1 THEN 
                                    CASE 
                                        WHEN gg.Muc_Giam_Gia > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                        ELSE gg.Muc_Giam_Gia
                                    END
                                ELSE 0
                            END
                        ) AS Tong_Gia_Giam,
                        SUM(hdct.Gia * hdct.So_Luong) - SUM(
                            CASE
                                WHEN gg.Kieu_Giam = 0 THEN 
                                    CASE 
                                        WHEN hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100 > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                        ELSE hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100
                                    END
                                WHEN gg.Kieu_Giam = 1 THEN 
                                    CASE 
                                        WHEN gg.Muc_Giam_Gia > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                                        ELSE gg.Muc_Giam_Gia
                                    END
                                ELSE 0
                            END
                        ) AS Tong_Doanh_Thu
                    FROM 
                        HoaDon hd
                    INNER JOIN 
                        HoaDonChiTiet hdct ON hd.ID_Hoa_Don = hdct.ID_Hoa_Don
                    INNER JOIN 
                        SanPham sp ON hdct.ID_San_Pham = sp.ID_San_Pham
                    LEFT JOIN 
                        GiamGia gg ON hd.ID_Giam_Gia = gg.ID_Giam_Gia
                    WHERE 
                        hd.Trang_Thai = 1 -- Chỉ lấy các hóa đơn đã thanh toán
                             AND CAST(hd.Ngay_Thanh_Toan  AS DATE)= CAST(GETDATE() AS DATE)
                    GROUP BY 
                        sp.Ten_San_Pham,
                        hd.Ngay_Thanh_Toan
                    ORDER BY 
                        sp.Ten_San_Pham,
                        hd.Ngay_Thanh_Toan;
    """;

    try (Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            ThongKe_Response tk = ThongKe_Response.builder()
                    .sanPhamBan(rs.getString(1))
                    .ngayThanhToan(rs.getDate(2))
                    .soLuong(rs.getInt(3))
                    .tongGiaBan(rs.getInt(4))
                    .tongGiaGiam(rs.getInt(5))
                    .tongDoanhThu2(rs.getInt(6))
                    .build();
            listTKT.add(tk);
        }
        return listTKT;
    } catch (Exception e){
        e.printStackTrace();
        return listTKT;
    }
    
}

    public ArrayList<ThongKe_Response> getALL_ThongKeTableDate(Date startDate, Date endDate) {
    ArrayList<ThongKe_Response> listTKT = new ArrayList<>();
    listTKT.clear();
    String sql = """
        SELECT 
            sp.Ten_San_Pham,
            hd.Ngay_Thanh_Toan,
            SUM(hdct.So_Luong) AS So_Luong_Ban,
            SUM(hdct.Gia * hdct.So_Luong) AS Tong_Gia_Ban,
            SUM(
                CASE
                    WHEN gg.Kieu_Giam = 0 THEN 
                        CASE 
                            WHEN hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100 > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                            ELSE hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100
                        END
                    WHEN gg.Kieu_Giam = 1 THEN 
                        CASE 
                            WHEN gg.Muc_Giam_Gia > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                            ELSE gg.Muc_Giam_Gia
                        END
                    ELSE 0
                END
            ) AS Tong_Gia_Giam,
            SUM(hdct.Gia * hdct.So_Luong) - SUM(
                CASE
                    WHEN gg.Kieu_Giam = 0 THEN 
                        CASE 
                            WHEN hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100 > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                            ELSE hdct.Gia * hdct.So_Luong * gg.Muc_Giam_Gia / 100
                        END
                    WHEN gg.Kieu_Giam = 1 THEN 
                        CASE 
                            WHEN gg.Muc_Giam_Gia > gg.Muc_Giam_Gia_Toi_Da THEN gg.Muc_Giam_Gia_Toi_Da
                            ELSE gg.Muc_Giam_Gia
                        END
                    ELSE 0
                END
            ) AS Tong_Doanh_Thu
        FROM 
            HoaDon hd
        INNER JOIN 
            HoaDonChiTiet hdct ON hd.ID_Hoa_Don = hdct.ID_Hoa_Don
        INNER JOIN 
            SanPham sp ON hdct.ID_San_Pham = sp.ID_San_Pham
        LEFT JOIN 
            GiamGia gg ON hd.ID_Giam_Gia = gg.ID_Giam_Gia
        WHERE 
            hd.Trang_Thai = 1 -- Chỉ lấy các hóa đơn đã thanh toán
                 AND hd.Ngay_Thanh_Toan BETWEEN ? AND ?
        GROUP BY 
            sp.Ten_San_Pham,
            hd.Ngay_Thanh_Toan
        ORDER BY 
            sp.Ten_San_Pham,
            hd.Ngay_Thanh_Toan;
    """;
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setDate(1, new java.sql.Date(startDate.getTime()));
        ps.setDate(2, new java.sql.Date(endDate.getTime()));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ThongKe_Response tk = new ThongKe_Response();
            tk.setSanPhamBan(rs.getString(1));
            tk.setNgayThanhToan(rs.getDate(2));
            tk.setSoLuong(rs.getInt(3));
            tk.setTongGiaBan(rs.getInt(4));
            tk.setTongGiaGiam(rs.getInt(5));
            tk.setTongDoanhThu2(rs.getInt(6));
            listTKT.add(tk);
        }
        return listTKT;
    } catch (Exception e) {
        e.printStackTrace();
        return listTKT;
    }
}
public ArrayList<ThongKe_Response> getALL_ThongKeTongDoanhThuDate(Date startDate, Date endDate) {
    ArrayList<ThongKe_Response> listTKT = new ArrayList<>();
    listTKT.clear();
    String sql = """
        Select sum(Tong_Gia)
            From HoaDon
            where Trang_Thai = 1
            and Ngay_Thanh_Toan BETWEEN ? and ?
    """;
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setDate(1, new java.sql.Date(startDate.getTime()));
        ps.setDate(2, new java.sql.Date(endDate.getTime()));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ThongKe_Response tk = new ThongKe_Response();
            tk.setTongDoanhThuDate(rs.getInt(1));
            listTKT.add(tk);
        }
        return listTKT;
    } catch (Exception e) {
        e.printStackTrace();
        return listTKT;
    }
}
public ArrayList<ThongKe_Response> getALL_ThongKeHoaDonDate(Date startDate, Date endDate){
        ArrayList<ThongKe_Response> listHDN = new ArrayList<>();
        listHDN.clear();
        String sql = """
                     SELECT COUNT(*) AS SoHoaDonDaThanhToanHomNay
                                            FROM HoaDon
                                            WHERE Trang_Thai = 1
                       					 and Ngay_Thanh_Toan BETWEEN ? and ?
                     """;
        try (Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
        ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ThongKe_Response tk = ThongKe_Response.builder()
                        .tongHoaDonDate(rs.getInt(1))
                        .build();
                        listHDN.add(tk);
           }
            return listHDN;
        }catch (Exception e){
                return listHDN;
                }
    }
public static void main(String[] args) {
        ThongKe_Repository t = new ThongKe_Repository();
        System.out.println(t.getAll_ChiTietSanPham());
    }
}
