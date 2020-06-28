package ai.biomind.cdss.controller;
import ai.biomind.cdss.domain.User;
import ai.biomind.cdss.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 * <p>
 * Create by l.m.h on ,
 **/
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user/add")
    public User addUser(@RequestParam(name = "name") String name,
                        @RequestParam(name = "pass") String pass) {
        return userRepository.save(new User(null, name, pass));
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable(name = "id") Long id) {
        System.out.println(id);
        return userRepository.getOne(id);
    }

    @RequestMapping("/user")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
