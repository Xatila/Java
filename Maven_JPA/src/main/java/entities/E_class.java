package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "e_class")
public class E_class extends Car {
    private static final int price = 7000;
    private static final String type = "combi";
    private static final String model = "w214";
    private static final int hp = 177;
    private static final int year = 2007;
    private static final String fuelType = "A95";

    public E_class(){
        super(type,model,fuelType,hp,year,price);
    }

}
