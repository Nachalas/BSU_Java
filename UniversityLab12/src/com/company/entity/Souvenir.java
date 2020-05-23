package com.company.entity;

import java.util.Objects;

public class Souvenir {
    private long id;
    private String name;
    private long manufacturer_id;
    private String date;
    private long price;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getManufacturer_id() { return manufacturer_id; }
    public void setManufacturer_id(long manufacturer_id) { this.manufacturer_id = manufacturer_id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public long getPrice() { return price; }
    public void setPrice(long price) { this.price = price; }

    public Souvenir(long id, String name, long manufacturer_id, String date, long price) {
        this.id = id;
        this.name = name;
        this.manufacturer_id = manufacturer_id;
        this.date = date;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Souvenir souvenir = (Souvenir) o;
        return id == souvenir.id &&
                manufacturer_id == souvenir.manufacturer_id &&
                price == souvenir.price &&
                Objects.equals(name, souvenir.name) &&
                Objects.equals(date, souvenir.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer_id, date, price);
    }

    @Override
    public String toString() {
        return "S: " + id + ", Name: " + name + ", M_ID: " + manufacturer_id + ", Date: " + date + ", Price: " + price;
    }
}
