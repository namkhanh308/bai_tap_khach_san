package model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class HoaDon {
    private Nguoi nguoi;
    private PhongTro phongTro;
    LocalDate checkIn;
    LocalDate checkOut;

    public HoaDon() {
    }

    public HoaDon(Nguoi nguoi, PhongTro phongTro, LocalDate checkIn, LocalDate checkOut) {
        this.nguoi = nguoi;
        this.phongTro = phongTro;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long getPrice() {
        long result;
        long numDay = DAYS.between(checkIn, checkOut);
        int price = phongTro.getPrice();
        result = price * numDay;
        return result;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public PhongTro getPhongTro() {
        return phongTro;
    }

    public void setPhongTro(PhongTro phongTro) {
        this.phongTro = phongTro;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
        this.phongTro.setStatus(false);
    }

    public LocalDate getCheckOut() {
        return checkOut;

    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "nguoi=" + nguoi +
                ", phongTro=" + phongTro +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
