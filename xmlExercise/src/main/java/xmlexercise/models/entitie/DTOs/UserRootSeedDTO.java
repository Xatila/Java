package xmlexercise.models.entitie.DTOs;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRootSeedDTO {

    @XmlElement(name = "user")
    private List<UserSeedDTO> users;

    public List<UserSeedDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserSeedDTO> users) {
        this.users = users;
    }
}
