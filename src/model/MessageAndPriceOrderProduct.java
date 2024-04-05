package model;

public class MessageAndPriceOrderProduct {
    private Double price;
    private String message;

    public MessageAndPriceOrderProduct() {}

    public MessageAndPriceOrderProduct(Double price, String message) {
        this.price = price;
        this.message = message;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}