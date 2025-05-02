package App.Repository;


import App.Entity.User;
import App.Interface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.*;

import java.util.List;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;


@Repository
public class UserRepository implements UserInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${SECRET_KEY}")
    private String SECRET_KEY;

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

    @Override
    public String login(String username, String password) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE name=?",
                    BeanPropertyRowMapper.newInstance(User.class), username);
            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                return Jwts.builder()
                        .setSubject(user.getName())
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                        .compact();
            }
            return null;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
