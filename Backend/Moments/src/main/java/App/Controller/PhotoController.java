package App.Controller;

import App.Entity.Photo;
import App.Repository.PhotoRepository;
import App.Service.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
