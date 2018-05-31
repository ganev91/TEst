package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    Map<String, User> hm = new HashMap<>();

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        hm.put("username",user);
        return user;
    }
    @RequestMapping(value = "/user/{username}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String username) {
        hm.remove(username);
        throw new NoSuchElementException();

    }
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public User get(@PathVariable String username) {
        User user = hm.get(username);
        return user;

    }
//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
//    public User update(@RequestParam String name) {
//        return
//
//
//    }
}
