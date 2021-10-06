package view;

import controller.Hotel;
import model.HoaDon;
import model.Nguoi;
import model.PhongTro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<Nguoi> nguois = new ArrayList<>();
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        ArrayList<PhongTro> phongTros = new ArrayList<>();
        Hotel hotel = new Hotel(nguois, phongTros, hoaDons);
        int choose = -1;
        while (choose != 0) {
            System.out.println("1. Thêm phòng: ");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Thêm hóa đơn");
            System.out.println("4. Hiển thị khách hàng");
            System.out.println("5. Hiển thị phòng");
            System.out.println("6. Hiển thị hóa đơn");
            System.out.println("7. Chức năng Tính tiền cho khách hàng");
            System.out.println("8. Chức năng trả phòng: ");
            System.out.println("9. Thống kê theo phòng: ");
            System.out.println("10. Chức năng thống kê theo cá nhân");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Chức năng thêm phòng trọ");
                    System.out.println("Nhập tên phòng");
                    Scanner scanner1 = new Scanner(System.in);
                    String name = scanner1.nextLine();
                    System.out.println("Nhập kiểu phòng");
                    Scanner scanner7 = new Scanner(System.in);
                    String type = scanner7.nextLine();
                    System.out.println("Nhập giá phòng");
                    Scanner scanner2 = new Scanner(System.in);
                    int price = scanner2.nextInt();
                    phongTros.add(new PhongTro(name, type, price));
                    break;
                case 2:
                    System.out.println("Chức năng thêm khác hàng");
                    System.out.println("Nhập tên khách hàng");
                    Scanner scanner3 = new Scanner(System.in);
                    String fullName = scanner3.nextLine();
                    System.out.println("Nhập ngày sinh");
                    String DoB = scanner3.nextLine();
                    Scanner scanner9 = new Scanner(System.in);
                    System.out.println("Nhập CMND");
                    String cmnd = scanner9.nextLine();
                    if (hotel.isExistNguoi(fullName, DoB, cmnd) == null) {
                        nguois.add(new Nguoi(fullName, DoB, cmnd));
                    } else {
                        hotel.isExistNguoi(fullName, DoB, cmnd).setAvailble(true);
                        hotel.isExistNguoi(fullName, DoB, cmnd).setLuot(hotel.isExistNguoi(fullName, DoB, cmnd).getLuot() + 1);
                    }
                    System.out.println(hotel.isExistNguoi(fullName, DoB, cmnd).getLuot());
                    break;
                case 3:
                    System.out.println("Thêm hóa đơn: ");
                    System.out.println("Mời bạn nhập vào CMND");
                    Scanner scanner4 = new Scanner(System.in);
                    String findCmnd = scanner4.nextLine();
                    if (hotel.TimNguoiTheoCMND(findCmnd) == null || hotel.TimNguoiTheoCMND(findCmnd).isAvailble() == false) {
                        System.out.println("Số CMND bạn nhập vào không đúng");
                    } else {
                        Scanner scanner5 = new Scanner(System.in);
                        System.out.println("Bạn muốn chọn phòng nào: A/B/C/D");
                        hotel.HienThiPhong();
                        String chon = scanner5.nextLine();
                        if (hotel.findPhongTro(chon) == null || hotel.findPhongTro(chon).isStatus() == false) {
                            System.out.println("Bạn nhập sai");
                        } else {
                            Nguoi a = hotel.TimNguoiTheoCMND(findCmnd);
                            PhongTro b = hotel.findPhongTro(chon);
                            System.out.println("Nhập vào ngày đến: ");
                            String ngayDen = scanner5.nextLine();
                            LocalDate DateIn = LocalDate.parse(ngayDen, DateTimeFormatter.ISO_LOCAL_DATE);
                            System.out.println("Nhập vào ngày đi");
                            String ngayDi = scanner5.nextLine();
                            LocalDate DateOut = LocalDate.parse(ngayDi, DateTimeFormatter.ISO_LOCAL_DATE);
                            hoaDons.add(new HoaDon(a, b, DateIn, DateOut));
                            a.setLuot(1);
                            a.setAvailble(true);
                            b.setCount(b.getCount() + 1);
                            b.setStatus(false);
                        }
                        break;
                    }
                case 4:
                    System.out.println("Chức năng hiển thị khách hàng");
                    hotel.HienThiNguoiTrangThaiTrue();
                    break;
                case 5:
                    System.out.println("Chức năng hiển thị phòng");
                    hotel.HienThiPhong();
                    break;
                case 6:
                    System.out.println("Chức năng hiển thị hóa đơn");
                    hotel.HienThiHoaDon();
                    break;
                case 7:
                    System.out.println("Chức năng Tính tiền cho khách hàng");
                    System.out.println("Mời bạn nhập vào CMT");
                    Scanner scanner8 = new Scanner(System.in);
                    String cmt = scanner8.nextLine();
                    System.out.println(hotel.getPriceForCMT(cmt));
                    break;
                case 8:
                    System.out.println("Chức năng trả phòng: ");
                    System.out.println("Mời bạn nhập vào cmt khách hàng muốn trả phòng");
                    Scanner scanner10 = new Scanner(System.in);
                    String cmt1 = scanner10.nextLine();
                    hotel.traPhong(cmt1);
                    break;
                case 9:
                    System.out.println("Chức năng thống kê phòng: ");
                    System.out.println("Mời bạn nhập vào tên phòng muốn thống kê");
                    Scanner scanner11 = new Scanner(System.in);
                    String cmt2 = scanner11.nextLine();
                    hotel.ThongKeTheoPhong(cmt2);
                    break;
                case 10:
                    System.out.println("Chức năng thống kê theo cá nhân");
                    System.out.println("Mời bạn nhập vào cmt của khách hàng");
                    Scanner scanner12 = new Scanner(System.in);
                    String cmt3 = scanner12.nextLine();
                    hotel.ThongKeTheoNguoi(cmt3);
                    break;
            }
        }


    }
}
