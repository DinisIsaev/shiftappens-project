package App.Interface;

import App.Entity.Photo;

import java.util.List;

public interface PhotoInterface {
    int save(Photo photo);

    int update(Photo photo);

    Photo findById(int id);

    int deleteById(int id);

    List<Photo> findAll();

    int deleteAll();

}

