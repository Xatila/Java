package services;
import models.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
public interface UserService {
    void registerUser(User user);
}
