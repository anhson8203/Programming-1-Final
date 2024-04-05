package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private String id;
    private String status;
    private List<Product> products;
    private Double totalMoney;
    private String accountId;

    public Order() {}

    public Order(String id, String status, List<Product> products, Double totalMoney, String accountId) {
        this.id = id;
        this.status = status;
        this.products = products;
        this.totalMoney = totalMoney;
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID = '" + id + '\n' +
                ", Status = '" + status + '\n' +
                ", Products = '" + products + '\n' +
                ", Total Money = $" + totalMoney + '\n' +
                ", Account ID = '" + accountId + '\n' + '}';
    }
}