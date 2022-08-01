package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Basic
    private String type;
    private String model;
    private String fuelType;
    private int hp;
    private int year;
    private int price;
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    protected Airplane(){};

    public Airplane(String type, String model, String fuelType, int hp, int year, int price) {
        this.type = type;
        this.model = model;
        this.fuelType = fuelType;
        this.hp = hp;
        this.year = year;
        this.price=price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
