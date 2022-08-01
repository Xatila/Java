package kevinsindustry.gameshop.entities;

import kevinsindustry.gameshop.entities.users.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @ManyToOne
    private User buyer;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> products;

    public Order(User buyer, Set<Game> products) {
        this.buyer = buyer;
        this.products = products;
    }

    public Order() {
        this.products=new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Set<Game> getProducts() {
        return products;
    }

    public void setProducts(Set<Game> products) {
        this.products = products;
    }
}
