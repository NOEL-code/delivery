package org.example.store.user;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public User join(@RequestBody Map<String, User> joinUser) {
        return userService.join(joinUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> loginUser) {
        User user = userService.login(loginUser);

        if(user != null) {
            return "login success";
        } else {
            return "login failed";
        }
    }
}
