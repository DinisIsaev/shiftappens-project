package App.Interface;

import App.Entity.Event;

import java.util.List;

public interface EventInterface {
    int save(Event event);

    int update(Event event);

    Event findById(int id);

    int deleteById(int id);

    List<Event> findAll();

    int deleteAll();

}

