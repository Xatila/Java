package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int product_id;
    private int customer_id;
    private int store_location_id;
    private LocalDate date;

    private String name;
    private int quantity;
    private double price;
    public Sale(){};

    public Sale(int product_id, int customer_id, int store_location_id, LocalDate date, String name, int quantity, double price) {
        this.product_id = product_id;
        this.customer_id = customer_id;
        this.store_location_id = store_location_id;
        this.date = date;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStore_location_id() {
        return store_location_id;
    }

    public void setStore_location_id(int store_location_id) {
        this.store_location_id = store_location_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
