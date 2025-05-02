package App.Controller;

import App.Entity.Photo;
import App.Repository.PhotoRepository;
import App.Entity.Photo;
import App.Entity.UserEvent;
import App.Repository.PhotoRepository;
import App.Repository.UserEventRepository;
import App.Service.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private ImageManager imageManager;

    @Autowired
    private PhotoRepository photoRepository;
    @PostMapping("auth/createAd")
    public int createAd(
            @RequestBody MultipartFile[] adsImages
    ) {
        try {
            String uploadDirectory = "/media/";
            String adsImagesString = "";

            for (MultipartFile imageFile : adsImages) {
                adsImagesString = uploadDirectory + imageManager.saveImageToStorage(imageFile);

                photoRepository.save(new Photo(adsImagesString,0, ));
            }
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }

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
