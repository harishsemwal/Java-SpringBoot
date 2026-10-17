
package org.codeArmy.service;

import org.codeArmy.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final Map<Integer, User> userDetails;

    public UserService() {
        this.userDetails = new HashMap<>();
    }

    public User createUser(User user) {
        if (user == null || userDetails.containsKey(user.getId())) {
            return null;
        }

        userDetails.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDetails.values());
    }

    public User getUserById(Integer id) {
        return userDetails.get(id);
    }

    public User updateUser(User user) {
        if (user == null || !userDetails.containsKey(user.getId())) {
            return null;
        }

        userDetails.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(Integer id) {
        if (id == null || !userDetails.containsKey(id)) {
            return false;
        }

        userDetails.remove(id);
        return true;
    }
}
