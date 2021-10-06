package controller;

import model.HoaDon;
import model.Nguoi;
import model.PhongTro;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Nguoi> nguois = new ArrayList<>();
    private ArrayList<PhongTro> phongTros = new ArrayList<>();
    private ArrayList<HoaDon> hoaDons = new ArrayList<>();

    public Hotel(ArrayList<Nguoi> nguois, ArrayList<PhongTro> phongTros) {
        this.nguois = nguois;
        this.phongTros = phongTros;
    }

    public Hotel(ArrayList<Nguoi> nguois, ArrayList<PhongTro> phongTros, ArrayList<HoaDon> hoaDons) {
        this.nguois = nguois;
        this.phongTros = phongTros;
        this.hoaDons = hoaDons;
    }

    public Hotel(ArrayList<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public PhongTro findPhongTro(String phongtro) {
        for (PhongTro phongTro : phongTros) {
            if (phongTro.getNameRoom().equals(phongtro)) {
                return phongTro;
            }
        }
        return null;
    }

    public Nguoi TimNguoiTheoCMND(String CMND) {
        for (Nguoi nguoi : nguois) {
            if (nguoi.getCMND().equals(CMND)) {
                return nguoi;
            }
        }
        return null;
    }

    public long getAllPrice() {
        long sum = 0;
        for (HoaDon hoaDon : hoaDons) {
            sum += hoaDon.getPrice();
        }
        return sum;
    }

    public void HienThiNguoiTrangThaiTrue() {
        for (Nguoi nguoi : nguois) {
            if (nguoi.isAvailble() == true) {
                System.out.println(nguoi);
            }
        }
    }

    public void HienThiPhong() {
        for (PhongTro phongTro : phongTros) {
            System.out.println(phongTro);
        }
    }

    public void HienThiHoaDon() {
        for (HoaDon hoaDon : hoaDons) {
            System.out.println(hoaDon);
        }
    }

    public long getPriceForCMT(String cmt) {
        long sum = 0;
        for (HoaDon hoadon : hoaDons) {
            if (hoadon.getNguoi().getCMND().equals(cmt)) {
                sum += hoadon.getPrice();
            }
        }
        return sum;
    }

    public Nguoi isExistNguoi(String name, String DoB, String CMND) {
        for (Nguoi nguoi : nguois) {
            if (nguoi.getCMND().equals(CMND) && nguoi.getName().equals(name) && nguoi.getDoB().equals(DoB)) {
                return nguoi;
            }
        }
        return null;
    }

    public void traPhong(String cmt) {
        int index = -1;
        for (int i = 0; i < hoaDons.size(); i++) {
            if (hoaDons.get(i).getNguoi().getCMND().equals(cmt)) {
                hoaDons.get(i).getNguoi().setAvailble(false);
                index = i;
            }
        }
        hoaDons.get(index).getPhongTro().setSum(hoaDons.get(index).getPhongTro().getSum() + this.getPriceForCMT(cmt));
        hoaDons.get(index).getPhongTro().setStatus(true);
        hoaDons.get(index).getNguoi().setSum(hoaDons.get(index).getNguoi().getSum() + this.getPriceForCMT(cmt));
        hoaDons.remove(index);
    }

    public void ThongKeTheoPhong(String name) {
        PhongTro phongTro = findPhongTro(name);
        if (phongTro == null) {
            System.out.println("Bạn nhập sai tên phòng trọ");
        } else {
            System.out.println("Phòng: " + phongTro.getNameRoom());
            System.out.println("Kiểu phòng: " + phongTro.getTypeRoom());
            System.out.println("Giá phòng: " + phongTro.getPrice());
            System.out.println("Số khách đã thuê: " + phongTro.getCount());
            System.out.println("Số tiền đã thu được: " + phongTro.getSum());
        }
    }

    public void ThongKeTheoNguoi(String cmt) {
        Nguoi nguoi = this.TimNguoiTheoCMND(cmt);
        if (nguoi == null) {
            System.out.println("Bạn nhập sai tên người");
        } else {
            System.out.println("Tên: " + nguoi.getName());
            System.out.println("DoB: " + nguoi.getDoB());
            System.out.println("CMND: " + nguoi.getCMND());
            System.out.println("Số lần thuê phòng: " + nguoi.getLuot());
            if (nguoi.isAvailble() == true) {
                System.out.println("Trang thái hiện tại đang thuê");
            } else {
                System.out.println("Trạng thái hiện tại không đang thuê");
            }
            System.out.println("Tổng số tiền đã thuê: " + nguoi.getSum());
        }
    }
//    public void DisplayFullRoom(){
//        for (PhongTro phongTro: phongTros) {
//            if(phongTro.isStatus() == true){
//                System.out.println(phongTro);
//            }
//        }
//    }
//    public void traPhong(String name) {
//        int index = -1;
//        for (int i = 0; i < hoaDons.size(); i++) {
//            if(hoaDons.get(i).getNguoi().getName().equals(name)){
//                hoaDons.get(i).getPhongTro().setStatus(true);
//                index = i;
//            }
//        }
//        hoaDons.remove(index);
//        }

    //    public void DisplayForOrder(){
//        for (HoaDon hoaDon : hoaDons ) {
//            System.out.println(hoaDon);
//        }
//    }
    public ArrayList<Nguoi> getNguois() {
        return nguois;
    }

    public void setNguois(ArrayList<Nguoi> nguois) {
        this.nguois = nguois;
    }

    public ArrayList<PhongTro> getPhongTros() {
        return phongTros;
    }

    public void setPhongTros(ArrayList<PhongTro> phongTros) {
        this.phongTros = phongTros;
    }

    public ArrayList<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(ArrayList<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

}
