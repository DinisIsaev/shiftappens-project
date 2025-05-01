package App.Repository;



import App.Interface.UserEventInterface;
import App.Entity.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserEventRepository implements UserEventInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserEventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(UserEvent user_events ) {
        return jdbcTemplate.update("INSERT INTO user_events(users_id,events_id) VALUES(?,?)",
                new Object[] {user_events.getUsers_id(),user_events.getEvents_id() });
    }

    @Override
    public int update(UserEvent user_events ) {
        return jdbcTemplate.update("UPDATE user_events SET users_id=?, events_id=? WHERE id=?",
                new Object[] { user_events.getUsers_id(), user_events.getEvents_id(), user_events.getUsers_events_id() });
    }

    @Override
    public UserEvent findById(int id) {
        try {
            UserEvent user_events  = jdbcTemplate.queryForObject("SELECT * FROM user_events  WHERE id=?",
                    BeanPropertyRowMapper.newInstance(UserEvent.class), id);
            return user_events ;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM user_events s_events  WHERE id=?", id);
    }

    @Override
    public List<UserEvent> findAll() {
        return jdbcTemplate.query("SELECT * FROM user_events s_events ", BeanPropertyRowMapper.newInstance(UserEvent.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM user_events s_events ");
    }


}
