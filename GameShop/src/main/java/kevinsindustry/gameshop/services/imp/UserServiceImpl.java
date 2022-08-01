package kevinsindustry.gameshop.services.imp;

import kevinsindustry.gameshop.entities.users.LoginDTO;
import kevinsindustry.gameshop.entities.users.RegisterDTO;
import kevinsindustry.gameshop.entities.users.User;
import kevinsindustry.gameshop.repositories.UserRepository;
import kevinsindustry.gameshop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private User currentUser;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.currentUser =null;
    }

    @Override
    public User register(RegisterDTO registerDTO) {
        ModelMapper mapper = new ModelMapper();
        User registrer = mapper.map(registerDTO, User.class);
        long count = this.userRepository.count();
        if (count == 0) {
            registrer.setAdmin(true);
        }
        return this.userRepository.save(registrer);
    }

    @Override
    public Optional<User> login(LoginDTO loginDTO) {
        if (currentUser!=null){
            System.out.println("sssss");
        }
         Optional<User> user = this.userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

         user.ifPresent(value->this.currentUser=value);
            return user;
    }

    @Override
    public User LoggedUser() {
        return this.currentUser;
    }

    public User getCurrentUser(){

        return this.currentUser;
    }

    @Override
    public User logout() {
        return this.currentUser=null;
    }
}
