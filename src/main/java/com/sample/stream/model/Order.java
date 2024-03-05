package com.sample.stream.model;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Order {

    private long orderNumber;
    private long quantity;
    private String productName;
    private String productDesc;
    private OrderStatus orderStatus;

	public Order(long orderNumber, long quantity, String productName, String productDesc) {
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.productName = productName;
        this.productDesc = productDesc;
       
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", orderStatus='" + orderStatus + '\'' +                
                '}';
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }


    public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus status) {
		this.orderStatus = status;
	}

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    
    public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}



	public static class OrderBuilder {
    	
    	private Random rand = new Random();
    	
    	private long orderNumber = rand.nextLong(50000)+1000;
    	
    	private long quantity = rand.nextLong(25)+1;
    	
    	private String productName = RandomStringUtils.randomAlphanumeric(10);
    	
    	private String productDesc = RandomStringUtils.randomAlphanumeric(10);
    	
    	public OrderBuilder() {}
    	
    	public Order build() {
    		return new Order(orderNumber, quantity, productName, productDesc);
    	}

    	
    }
}
