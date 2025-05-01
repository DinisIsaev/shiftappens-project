package App.Interface;

import App.Entity.UserEvent;

import java.util.List;

public interface UserEventInterface {
    int save(UserEvent user);

    int update(UserEvent user);

    UserEvent findById(int id);

    int deleteById(int id);

    List<UserEvent> findAll();

    int deleteAll();

}

