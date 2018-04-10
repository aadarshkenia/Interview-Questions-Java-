package oopdesign.parkinglot;

public abstract class Vehicle {
    private int size;
    private String licenseNo;

    public Vehicle(int size, String licenseNo) {
        this.size = size;
        this.licenseNo = licenseNo;
    }

    public int getSize() {
        return size;
    }

    public String getLicenseNo() {
        return licenseNo;
    }
}
