import model.User;
import dao.UserInterface;
import dao.UserInterfaceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserAppl {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterfaceImpl();
        LocalDate now = LocalDate.now();
        User[] users =
                {
                        new User(1, "user1", now.minusYears(20)),
                        new User(2, "user2", now.minusYears(22)),
                        new User(3, "user3", now.minusYears(70)),
                        new User(4, "user4", now.minusYears(55)),
                        new User(5, "user5", now.minusDays(2))
                };
        Arrays.stream(users).forEach(userInterface::add);
        System.out.println("Size = " + userInterface.size());
        System.out.println("removed " + userInterface.remove(3));
        System.out.println("Size = " + userInterface.size());
        System.out.println("Get  1 = " + userInterface.find(1));

        System.out.println("get users between years 19 - 30: ");
        List<User> usersList = userInterface.
                findByAge(LocalDate.now().minusYears(30)
                        , LocalDate.now().minusYears(19));
        for (User user: usersList){
            System.out.println(user);
        }

    }
}
