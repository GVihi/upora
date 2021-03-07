package com.example.lib;

public class RAM implements Comparable<RAM> {
    public static final int DEFAULT_CAPACITY = 8;
    public static final int DEFAULT_SPEED = 2133;
    public static final int DEFAULT_CL = 16;

    private String brand;
    private int capacity;
    private int speed;
    private int casLatency;

    public RAM(String brand, int capacity, int speed, int casLatency) {
        this.brand = brand;
        this.capacity = capacity;
        this.speed = speed;
        this.casLatency = casLatency;
    }

    public RAM(String brand){
        this(brand, DEFAULT_CAPACITY, DEFAULT_SPEED, DEFAULT_CL);
    }

    public String getBrand() {
        return brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCasLatency() {
        return casLatency;
    }

    @Override
    public String toString(){
        return "RAM{" +
                "brand=" + brand +
                ", capacity=" + capacity +
                ", speed=" + speed +
                ", casLatency=" + casLatency +
                "}";
    }

    @Override
    public int compareTo(RAM ram) {
        return brand.compareTo(ram.getBrand());
    }
}
