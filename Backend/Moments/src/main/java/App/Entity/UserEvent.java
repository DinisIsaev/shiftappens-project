package App.Entity;

public class UserEvent {
    int users_id;
    int events_id;
    int users_events_id;

    public UserEvent() {
    }

    public UserEvent(int users_id, int events_id, int users_events_id) {
        this.users_id = users_id;
        this.events_id = events_id;
    }

    public int getUsers_events_id() {
        return users_events_id;
    }

    public void setUsers_events_id(int users_events_id) {
        this.users_events_id = users_events_id;
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
