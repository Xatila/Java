package kevinsindustry.gameshop.services;

import kevinsindustry.gameshop.entities.users.LoginDTO;
import kevinsindustry.gameshop.entities.users.RegisterDTO;
import kevinsindustry.gameshop.entities.users.User;

import java.util.Optional;

public interface UserService {
    User register(RegisterDTO registerDTO);
    Optional<User> login(LoginDTO loginDTO);
    User LoggedUser();
    User logout();
}
