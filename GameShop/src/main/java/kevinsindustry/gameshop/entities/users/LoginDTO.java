package kevinsindustry.gameshop.entities.users;

public class LoginDTO {
    private String email;
    private String password;


    public LoginDTO(String[] command) {
        this.email = command[1];
        this.password = command[2];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
