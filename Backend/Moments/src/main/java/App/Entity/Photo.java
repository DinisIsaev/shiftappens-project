package App.Entity;

public class Photo {

    int id;
    String path;
    int likes;
    int events_id;
    int users_id;

    public Photo(int id, String path, int likes, int events_id, int users_id) {
        this.id = id;
        this.path = path;
        this.likes = likes;
        this.events_id = events_id;
        this.users_id = users_id;
    }

    public Photo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getEvents_id() {
        return events_id;
    }

    public void setEvents_id(int events_id) {
        this.events_id = events_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}
