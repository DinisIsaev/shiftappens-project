package App.Controller;
import App.Entity.Photo;
import App.Entity.PhotoWrapper;
import App.Repository.PhotoRepository;
import App.Service.ImageManager;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

@RestController
@EnableAutoConfiguration
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private ImageManager imageManager;

    @Value("${SECRET_KEY}")
    private String jwtSecret;

    private int decodeJwtToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.get("id").toString());
    }

    @Autowired
    private PhotoRepository photoRepository;
    @PostMapping("auth/createAd")
    public int createAd(@RequestBody PhotoWrapper photoWrapper) {
        try {
            String uploadDirectory = "/media/";
            String adsImagesString = "";

            String token = photoWrapper.getToken();

            int userId = decodeJwtToken(token);

            for (MultipartFile imageFile : photoWrapper.getFile()) {
                adsImagesString = uploadDirectory + imageManager.saveImageToStorage(imageFile);

                photoRepository.save(new Photo(adsImagesString,0,photoWrapper.getEventID(), userId));
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
