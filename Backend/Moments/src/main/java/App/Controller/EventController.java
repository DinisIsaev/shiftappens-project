package App.Controller;

import App.Entity.Event;
import App.Entity.User;
import App.Entity.UserEvent;
import App.Repository.EventRepository;
import App.Repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/get/{id}")
    public Event getEventById(@PathVariable int id){
        return eventRepository.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<Event> getUserEvents(@PathVariable int id){
        List<Event> list = new ArrayList<>();
        List<UserEvent> userEvents;

        try{
            userEvents = userEventRepository.findByUser(id);

            for(UserEvent userEvent : userEvents){
                list.add(eventRepository.findById(userEvent.getEvents_id()));
            }

            return list;

        }
        catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    @PostMapping("/add")
    public int addEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }
















}