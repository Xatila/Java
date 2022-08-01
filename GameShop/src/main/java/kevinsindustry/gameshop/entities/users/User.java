package kevinsindustry.gameshop.entities.users;

import kevinsindustry.gameshop.entities.Game;
import kevinsindustry.gameshop.entities.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String full_name;

    @ManyToMany
    private Set<Game> games;

    @Column(nullable = false)
    private boolean admin;

    @OneToMany(mappedBy = "buyer")
    private Set<Order> orders;

    public User() {
        this.games=new HashSet<>();
        this.orders=new HashSet<>();
    }

    public User(String email, String password, String full_name) {
        this.email = email;
        this.password = password;
        this.full_name = full_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
