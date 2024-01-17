package ru.finaiproject.java;

import java.util.Objects;

public class NotePads {

    private String ram;
    private String HDCapacity;
    private String brand;
    private String color;

    public NotePads(String ram, String HDCapacity, String brand, String color) {
        this.ram = ram;
        this.HDCapacity = HDCapacity;
        this.brand = brand;
        this.color = color;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHDCapacity() {
        return HDCapacity;
    }

    public void setHDCapacity(String HDCapacity) {
        this.HDCapacity = HDCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "NotePads{" +
                "ram=" + ram +
                ", HDCapacity=" + HDCapacity +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(ram,HDCapacity,brand,color);
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NotePads notePads = (NotePads) obj;
        return ram.equals(notePads.ram) && HDCapacity.equals(notePads.HDCapacity) && color.equals(notePads.color) && brand.equals(notePads.brand);
    }
}
