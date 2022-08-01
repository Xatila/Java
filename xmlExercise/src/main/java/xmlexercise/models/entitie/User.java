package xmlexercise.models.entitie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String LastName;
    private Integer age;
    @OneToMany(mappedBy = "seller")
    private Set<Product> soldProducts;
    @ManyToMany
    private Set<User> friends;


    public User(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        LastName = lastName;
        this.age = age;
    }

    public User() {
        this.friends = new HashSet<>();
        this.soldProducts = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
