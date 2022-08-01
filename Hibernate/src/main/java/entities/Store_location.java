package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class Store_location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location_name")
    private String location_name;

    @OneToMany()
    private Set<Sale> sales;

    public Store_location(String location_name) {
        this.location_name = location_name;
    }

    protected Store_location(){}

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }


}
