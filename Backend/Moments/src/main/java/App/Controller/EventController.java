package App.Controller;

import App.Entity.Event;
import App.Repository.EventRepository;
import App.Repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/event")
public class EventController
{

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserEventRepository userEventRepository;

    @GetMapping("/getall")
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    @GetMapping("/id")
    public Event getEventById(@RequestParam int id){
        return eventRepository.findById(id);
    }
    @GetMapping("/user")
    public List<Event> getUserEvents(@RequestParam int id){
      //  List<Event> list = new List<>;
      //  List



    }

    @PostMapping("/add")
    public int addEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }
















}