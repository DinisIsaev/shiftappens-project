package App.Repository;


import App.Entity.Event;
import App.Interface.EventInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EventRepository implements EventInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Event event) {
        return jdbcTemplate.update("INSERT INTO EVENTS (name,place,date,description,exposure,users_id) VALUES(?,?,?,?,?,?)",
                new Object[] { event.getName(), event.getPlace(), event.getDate(), event.getDescription(),event.getExposure(),event.getUsers_id() });
    }

    @Override
    public int update(Event event) {
        return jdbcTemplate.update("UPDATE EVENTS SET name=?, place=?, date=?,description=?,exposure=?,users_id=? WHERE id=?",
                new Object[] { event.getName(),event.getPlace(),event.getDate(),event.getDescription(),event.getExposure(),event.getUsers_id(),event.getId() });
    }

    @Override
    public Event findById(int id) {
        try {
            Event event = jdbcTemplate.queryForObject("SELECT * FROM EVENTS WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Event.class), id);

            return event;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM EVENTS WHERE id=?", id);
    }

    @Override
    public List<Event> findAll() {
        return jdbcTemplate.query("SELECT * FROM EVENTS", BeanPropertyRowMapper.newInstance(Event.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE * FROM EVENTS");
    }


}
