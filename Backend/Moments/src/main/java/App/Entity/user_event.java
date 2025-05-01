package App.Entity;

public class user_event {
    int users_id;
    int events_id;

    public user_event() {
    }

    public user_event(int users_id, int events_id) {
        this.users_id = users_id;
        this.events_id = events_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getEvents_id() {
        return events_id;
    }

    public void setEvents_id(int events_id) {
        this.events_id = events_id;
    }
}
