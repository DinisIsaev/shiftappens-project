package App.Interface;

import App.Entity.User;

import java.util.List;

public interface UserInterface {
    int save(User user);

    int update(User user);

    User findById(int id);

    int deleteById(int id);

    List<User> findAll();

    int deleteAll();

}

