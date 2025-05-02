package App.Entity;

import org.springframework.web.multipart.MultipartFile;

public class PhotoWrapper {
    private MultipartFile[] file;
    private String token;
    private int eventID;

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public PhotoWrapper(MultipartFile[] file, String token, int eventID) {
        this.file = file;
        this.token = token;
        this.eventID = eventID;
    }
}
