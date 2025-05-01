package App.Repository;


import App.Entity.User;
import App.Interface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO users (name,email,password) VALUES(?,?,?)",
                new Object[] { user.getName(), user.getEmail(), user.getPassword() });
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET name=?, email=?, password=? WHERE id=?",
                new Object[] { user.getName(), user.getEmail(), user.getPassword(), user.getId() });
    }

    @Override
    public User findById(int id) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?",
                    BeanPropertyRowMapper.newInstance(User.class), id);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM users");
    }


}
