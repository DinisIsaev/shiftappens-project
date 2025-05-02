package App.Controller;

import App.Entity.Photo;
import App.Entity.UserEvent;
import App.Repository.PhotoRepository;
import App.Repository.UserEventRepository;
import App.Service.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private ImageManager imageManager;

    @Autowired
    private PhotoRepository photoRepository;

    private final String imageDir = "/media";


    //Get image info from files
    @PostMapping("/get/{id}")
    public ResponseEntity<List<byte[]>> getPhoto(@RequestParam int user) {

        List<Photo> photos = new ArrayList<>();


        photos = photoRepository.findByUser(user);


        List<byte[]> images = new ArrayList<>();
        for (Photo photo : photos) {
            images.add(imageManager.presentImage(photo.getPath()));
        }

        return ResponseEntity.ok().body(images);
    }





}
