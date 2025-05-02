package App.Interface;

import App.Entity.UserEvent;

import java.util.List;

public interface UserEventInterface {
    int save(UserEvent user);

    int update(UserEvent user);

    List<UserEvent> findByEvent(int id);

    int deleteById(int id);

    List<UserEvent> findByUser(int user);

    List<UserEvent> findAll();

    int deleteAll();

}

