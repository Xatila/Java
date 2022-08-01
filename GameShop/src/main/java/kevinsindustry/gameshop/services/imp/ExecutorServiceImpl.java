package kevinsindustry.gameshop.services.imp;

import kevinsindustry.gameshop.entities.users.LoginDTO;
import kevinsindustry.gameshop.entities.users.RegisterDTO;
import kevinsindustry.gameshop.entities.users.User;
import kevinsindustry.gameshop.services.ExecutorService;
import kevinsindustry.gameshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExecutorServiceImpl implements ExecutorService {


    private final UserService userService;

    @Autowired
    public ExecutorServiceImpl(UserService userService) {
        this.userService = userService;

    }

    @Override
    public String execute(String command) {
        String[] commandPieces = command.split("\\|");

        String commandName = commandPieces[0];
        String output = switch (commandName) {
            case REGISTER_USER -> {
                RegisterDTO registerDTO = new RegisterDTO(commandPieces);
                User user = userService.register(registerDTO);

                yield String.format("%s was registered", user.getFull_name());
            }
            case LOGIN_USER -> login(commandPieces);

            case LOGOUT_USER -> {
                User loggedUser = this.userService.LoggedUser();
                this.userService.logout();
                yield String.format("%s Good Bye!", loggedUser.getFull_name());
            }
            default -> "unknown command.";
        };
        return output;
    }

    private String login(String[] parts) {
        LoginDTO loginDTO = new LoginDTO(parts);
        Optional<User> user = userService.login(loginDTO);
        if (user.isPresent()) {
            return String.format("Welcome %s !", user.get().getFull_name());
        } else {
            return ("Ko naprai e? Krashna programata! Celete gi tiq paroli..");
        }

    }
}
