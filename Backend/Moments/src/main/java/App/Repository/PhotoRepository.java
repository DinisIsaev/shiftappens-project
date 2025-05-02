package App.Repository;


import App.Entity.Photo;
import App.Interface.PhotoInterface;
import App.Interface.PhotoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoRepository implements PhotoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PhotoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Photo photo) {
        return jdbcTemplate.update("INSERT INTO photos (path,events_id,users_id) VALUES(?,?,?)",
                new Object[] { photo.getPath(), photo.getEvents_id(), photo.getUsers_id()});

    }

    @Override
    public int update(Photo photo) {
        return jdbcTemplate.update("UPDATE photos SET path=?, likes=?, events_id=?,users_id=? WHERE id=?",
                new Object[] { photo.getPath(), photo.getLikes(), photo.getEvents_id(), photo.getUsers_id()});
    }

    @Override
    public Photo findById(int id) {
        try {
            Photo photo = jdbcTemplate.queryForObject("SELECT * FROM photos WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Photo.class), id);
            return photo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM photos WHERE id=?", id);
    }

    @Override
    public List<Photo> findAll() {
        return jdbcTemplate.query("SELECT * FROM photos", BeanPropertyRowMapper.newInstance(Photo.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM photos");
    }


}
