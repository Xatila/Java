package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "acconts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne
    private User user;

    protected Account(){};

    public Account(BigDecimal balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUse() {
        return user;
    }

    public void setUse(User use) {
        this.user = use;
    }
}
