package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "c_class")
public class C_class extends Car {
    private static final int price = 50000;
    private static final String type = "sedan";
    private static final String model = "w206";
    private static final int hp = 211;
    private static final int year = 2015;
    private static final String fuelType = "diesel";

    public C_class(){
        super(type,model,fuelType,hp,year,price);
    }

}
