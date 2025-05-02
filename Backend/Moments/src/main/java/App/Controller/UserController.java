package App.Controller;

import App.Entity.Event;
import App.Entity.User;
import App.Entity.UserEvent;
import App.Repository.UserRepository;
import App.Repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEventRepository userEventRepository;

    @GetMapping("/getall")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable int id){
        return userRepository.findById(id);
    }

    @PostMapping("/add")
    public int addUser(@RequestBody User user){
        // Encrypt the password before saving the user
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    private String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    @PostMapping("/update")
    public int updateUser(@RequestBody User user){
        return userRepository.update(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody String user, @RequestParam String password){
    return userRepository.login(user, password);
    }
}