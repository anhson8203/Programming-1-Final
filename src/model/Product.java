package model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private Double price;
    private int amount;
    private String detail;
    private Double totalMoney;

    public Product() {}

    public Product(String id, String name, Double price, int amount, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "ID = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", price = $" + price +
                ", amount = " + amount +
                ", category = '" + detail + '\'';
    }

    public String toStringProduct() {
        return "ID = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", price = $" + price +
                ", amount = " + amount;
    }
}