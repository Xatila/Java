package services;

import models.Account;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User found = this.userRepository.findByUsername(user.getUsername());

        if (found == null) {
            this.userRepository.save(user);
        }
    }

}
