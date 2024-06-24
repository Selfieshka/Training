package ru.kpfu.itis.kirillakhmetov.work.streams;

import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private List<Product> products;
    private int totalAmount = 0;

    public Order(int orderId, int customerId, List<Product> products) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}