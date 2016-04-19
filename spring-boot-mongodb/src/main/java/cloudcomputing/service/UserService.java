package cloudcomputing.service;

import cloudcomputing.UserRepository;
import cloudcomputing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserService {

    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        return repository.findOne(userId);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.PUT, consumes = "application/json")
    public User update(@PathVariable String userId, @RequestBody User user) {
        User update = repository.findOne(userId);
        update.setFirstName(user.getFirstName());
        update.setLastName(user.getLastName());
        return repository.save(update);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String userId) {
        repository.delete(userId);
    }
}
