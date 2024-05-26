package org.example.store.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private Map<Integer, User> userTable = new HashMap<>();

    private int id = 0;

    public User save(User joinUser) {
        joinUser.setId(++id);
        userTable.put(joinUser.getId(), joinUser);
        return userTable.get(joinUser.getId());
    }
}
