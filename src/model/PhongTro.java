package model;

public class PhongTro {
    private String NameRoom;
    private String typeRoom;
    private int price;
    private boolean status;
    private int count;
    private double sum;
    public PhongTro() {
    }

    public PhongTro(String nameRoom, String typeRoom, int price) {
        NameRoom = nameRoom;
        this.typeRoom = typeRoom;
        this.price = price;
        this.status = true;
        this.count = 0;
        this.sum = 0;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNameRoom() {
        return NameRoom;
    }

    public void setNameRoom(String nameRoom) {
        NameRoom = nameRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PhongTro{" +
                "NameRoom='" + NameRoom + '\'' +
                ", typeRoom='" + typeRoom + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", sum=" + count +
                '}';
    }
}
