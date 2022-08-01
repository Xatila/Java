package xmlexercise.services;

import xmlexercise.models.entitie.DTOs.UserSeedDTO;
import xmlexercise.models.entitie.User;

import java.util.List;

public interface UserService {
    long getCountEntity();

    void seedUsers(List<UserSeedDTO> users);

    User getRandomUser();
}
