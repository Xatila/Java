package kevinsindustry.gameshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "games")
public class Game {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String trailer;

    @Column(name = "image_url")
    private String image_thumbnail;
    private double size;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate releaseDate;

    public Game(String title, String trailer, String image_thumbnail, double size, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.trailer = trailer;
        this.image_thumbnail = image_thumbnail;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public Game() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage_thumbnail() {
        return image_thumbnail;
    }

    public void setImage_thumbnail(String image_thumbnail) {
        this.image_thumbnail = image_thumbnail;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
