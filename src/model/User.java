package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class User {
    int id;
    String name;
    LocalDate birthDay;

    public User(int id, String name, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(now, birthDay);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
