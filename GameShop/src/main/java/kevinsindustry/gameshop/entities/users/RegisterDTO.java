package kevinsindustry.gameshop.entities.users;


import kevinsindustry.gameshop.exceptions.ValidationException;

public class RegisterDTO {
    private String email;
    private String password;
    private String confirm_password;
    private String full_name;


    public RegisterDTO(String[] commandPieces) {

        this.email=commandPieces[1];
        this.password=commandPieces[2];
        this.confirm_password =commandPieces[3];
        this.full_name=commandPieces[4];

    }
    private void validation(){
        if (!email.contains("@")){
            throw new ValidationException("Email must contain @.");
        }

        if (!password.equals(confirm_password)){
            System.out.println("Passwords do not match.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
