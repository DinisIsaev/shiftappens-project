package App.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ImageManager {

    private Path imageDir = Path.of("/media");

    //To view an image
    public byte[] presentImage(Path imageDir, String imageName) {

        try {
            if (Files.exists(imageDir)) {
                byte[] bytes = Files.readAllBytes(imageDir);
                return bytes;
            }
            else{
                return null;
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    public String saveImageToStorage(MultipartFile file){

        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename() ;

        try {
            if(!Files.exists(imageDir)){
                Files.createDirectories(imageDir);
            }


        Path filePath = imageDir.resolve(uniqueFileName);

        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return uniqueFileName;


    }

    // Delete an image
    public int deleteImage(String imageName){
        Path imagePath = Path.of(imageDir.toString(), imageName);
        try{
            if(Files.exists(imagePath)){
                Files.delete(imagePath);
                return 1;
            }
            else{
                return 0;
            }

        }
        catch(Exception e){
            e.printStackTrace();
            return 0;

        }
    }








}
