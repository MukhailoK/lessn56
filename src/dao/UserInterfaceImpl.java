package dao;

import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInterfaceImpl implements UserInterface {

    Map<Integer, User> userMap;

    public UserInterfaceImpl() {
        this.userMap = new HashMap<>();
    }

    //O(1)
    @Override
    public User find(int id) {
        return userMap.get(id);
    }

    //O(1)
    @Override
    public boolean add(User user) {
        if (user != null || !userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            return true;
        }
        return false;
    }

    //O(1)
    @Override
    public int size() {
        return userMap.size();
    }

    //O(1)
    @Override
    public User remove(int id) {
        return userMap.remove(id);
    }

    //O(n)
    @Override
    public List<User> findByAge(LocalDate from, LocalDate to) {
        List<User> res = new ArrayList<>();
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            if (entry.getValue().getBirthDay().isBefore(to.minusDays(1))
                    && entry.getValue().getBirthDay().isAfter(from.plusDays(1))) {
                res.add(entry.getValue());
            }
        }
        return res;
    }
}
