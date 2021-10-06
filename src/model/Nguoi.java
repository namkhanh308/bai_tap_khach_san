package model;

public class Nguoi {
    private String Name;
    private String DoB;
    private String CMND;
    private int luot;
    private boolean isAvailble;
    private long sum;

    public Nguoi() {
    }

    public Nguoi(String name, String doB, String CMND) {
        Name = name;
        DoB = doB;
        this.CMND = CMND;
        this.luot = 0;
        this.isAvailble = true;
        sum = 0;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public boolean isAvailble() {
        return isAvailble;
    }

    public void setAvailble(boolean availble) {
        isAvailble = availble;
    }

    public int getLuot() {
        return luot;
    }

    public void setLuot(int luot) {
        this.luot = luot;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "Name='" + Name + '\'' +
                ", DoB='" + DoB + '\'' +
                ", CMND='" + CMND + '\'' +
                ", luot=" + luot +
                ", isAvailble=" + isAvailble +
                '}';
    }
}
