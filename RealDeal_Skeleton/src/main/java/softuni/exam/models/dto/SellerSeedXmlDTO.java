package softuni.exam.models.dto;

import softuni.exam.models.enums.Raiting;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedXmlDTO {

    @XmlElement(name = "first-name")
    @Size(min = 2, max = 19)
    private String firstName;
    @Size(min = 2, max = 19)
    @XmlElement(name = "last-name")
    private String lastName;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    @XmlElement(name = "raiting")
    @NotNull
    private Raiting raiting;
    @XmlElement(name = "town")
    @NotBlank
    private String town;

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
