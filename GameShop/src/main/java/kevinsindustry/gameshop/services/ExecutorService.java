package kevinsindustry.gameshop.services;

public interface ExecutorService {

    String REGISTER_USER = "RegisterUser";
    String LOGIN_USER = "LoginUser";
    String LOGOUT_USER = "Logout";

    String ADD_GAME = "AddGame";

    String execute(String command);

    String REGISTER_USER_JSON = """
            {
                "commandName": "RegisterUser",
                "email": "azkazvam@abv.bg",
                "password": "1233",
                "confirmPassword": "1233";
                "fullName": "hackera"
            }
            """;
}
