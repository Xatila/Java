package softuni.exam.models.entities;

import softuni.exam.models.enums.Raiting;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Seller extends BaseEntity {

    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Raiting raiting;
    @Column(nullable = false)
    private String town;
    public Seller() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Raiting getRaiting() {
        return raiting;
    }

    public void setRaiting(Raiting raiting) {
        this.raiting = raiting;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

}
