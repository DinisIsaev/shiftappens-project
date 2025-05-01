package App.Entity;


import java.sql.Date;

public class Event {
    String name;
    int id;
    String place;
    Date date;
    String description;
    int exposure;
    int users_id;

    public Event(){
    }

    public Event(String name, int id, String place, Date date, String description, int exposure, int users_id) {
        this.name = name;
        this.id = id;
        this.place = place;
        this.date = date;
        this.description = description;
        this.exposure = exposure;
        this.users_id = users_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExposure() {
        return exposure;
    }

    public void setExposure(int exposure) {
        this.exposure = exposure;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}
