package App.Entity;

public class LoginWrapper {
    String Username;
    String Password;
    public LoginWrapper(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }



    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
