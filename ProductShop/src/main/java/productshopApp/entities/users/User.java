package productshopApp.entities.users;

import productshopApp.entities.products.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int age;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "sellerId")
    private List<Product> seelingProducts;

    @OneToMany(mappedBy = "buyerId")
    private List<Product> buyingProducts;

    @ManyToMany
    private List<User> friends;

    public User(){
        this.seelingProducts = new ArrayList<>();
        this.buyingProducts = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public User(int age, String first_name, String last_name) {
        this.age = age;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public List<Product> getSeelingProducts() {
        return seelingProducts;
    }

    public void setSeelingProducts(List<Product> seelingProducts) {
        this.seelingProducts = seelingProducts;
    }

    public List<Product> getBuyingProducts() {
        return buyingProducts;
    }

    public void setBuyingProducts(List<Product> buyingProducts) {
        this.buyingProducts = buyingProducts;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
