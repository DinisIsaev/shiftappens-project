package App.Repository;



import App.Interface.UserEventInterface;
import App.Entity.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserEventRepository implements UserEventInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserEventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(UserEvent users_events ) {
        return jdbcTemplate.update("INSERT INTO users_events(users_id,events_id) VALUES(?,?)",
                new Object[] {users_events.getUsers_id(),users_events.getEvents_id() });
    }

    @Override
    public int update(UserEvent users_events ) {
        return jdbcTemplate.update("UPDATE users_events SET users_id=?, events_id=? WHERE id=?",
                new Object[] { users_events.getUsers_id(), users_events.getEvents_id(), users_events.getUsers_events_id() });
    }

    @Override
    public List<UserEvent> findByEvent(int id) {
        List<UserEvent> users_events;

        try{
            users_events = jdbcTemplate.query("SELECT * FROM users_events WHERE events_id =?",
                    BeanPropertyRowMapper.newInstance(UserEvent.class),id);

        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return users_events;
    }
    @Override
    public List<UserEvent> findByUser(int user){
        List<UserEvent> users_events;

        try{
            users_events = jdbcTemplate.query("SELECT * FROM users_events WHERE users_id=?",
                    BeanPropertyRowMapper.newInstance(UserEvent.class),user);

        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return users_events;


    }


    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM users_events s_events  WHERE id=?", id);
    }

    @Override
    public List<UserEvent> findAll() {
        return jdbcTemplate.query("SELECT * FROM users_events s_events ", BeanPropertyRowMapper.newInstance(UserEvent.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM users_events s_events ");
    }


}
