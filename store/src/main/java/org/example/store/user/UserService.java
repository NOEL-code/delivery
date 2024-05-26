package org.example.store.user;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User join(Map<String, User> joinUser) {

        User requsetUser = new User();

        requsetUser.setUsername(String.valueOf(joinUser.get("email")));
        requsetUser.setPassword(String.valueOf(joinUser.get("password")));
        requsetUser.setEmail(String.valueOf(joinUser.get("email")));
        requsetUser.setPhone(String.valueOf(joinUser.get("phone")));

        return userRepository.save(requsetUser);

    }

    public User login(Map<String, String> loginUser) {
    }
}
