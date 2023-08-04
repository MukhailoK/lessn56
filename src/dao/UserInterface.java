package dao;

import model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserInterface {
    User find(int id);
    boolean add(User user);
    User remove(int id);
    List<User> findByAge(LocalDate from, LocalDate to);
    int size();
}
