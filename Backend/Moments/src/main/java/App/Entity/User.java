package App.Entity;

public class User {
    int id;
    String name;
    String email;
    String password;
    int users_id;

    public User() {
    }

    public User(int id, String name, String email, String password, int users_id) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.users_id = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}
