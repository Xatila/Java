package productshopApp.entities.products;

import productshopApp.entities.categories.Category;
import productshopApp.entities.users.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private BigDecimal price;

    @ManyToOne
    private User buyerId;
    @ManyToOne
    private User sellerId;

    @ManyToMany
    private List<Category> categories;

    public Product() {
        this.categories = new ArrayList<>();
    }

    public Product(String name, BigDecimal price) {
        this();
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
