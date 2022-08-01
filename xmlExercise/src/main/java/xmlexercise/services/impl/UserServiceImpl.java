package xmlexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xmlexercise.config.Validate;
import xmlexercise.models.entitie.DTOs.UserSeedDTO;
import xmlexercise.models.entitie.User;
import xmlexercise.repositories.UserRepo;
import xmlexercise.services.UserService;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final Validate validate;

    public UserServiceImpl(UserRepo userRepo, Validate validate) {
        this.userRepo = userRepo;
        this.modelMapper = new ModelMapper();
        this.validate = validate;
    }

    @Override
    public long getCountEntity() {
        return userRepo.count();
    }

    @Override
    public void seedUsers(List<UserSeedDTO> users) {
        users.stream().filter(validate::isValid)
                .map(userSeedDTO -> modelMapper.map(userSeedDTO, User.class)).forEach(userRepo::save);
    }

    @Override
    public User getRandomUser() {

        long randomId = ThreadLocalRandom.current().nextLong(1, userRepo.count()+1);
        return userRepo.findById(randomId).orElse(null);
    }
}
