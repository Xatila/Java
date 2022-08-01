package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "airplanes")
public class WarAirplane extends Airplane {

    private static final String type = "warPlane";
    private static final int price = 80000;
    private static final String model = "f16";
    private static final int hp = 977;
    private static final int year = 2012;
    private static final String fuelType = "Cerosine";

    public WarAirplane() {
        super(type, model, fuelType, hp, year, price);
    }
};
