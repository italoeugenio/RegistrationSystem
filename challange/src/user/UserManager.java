package user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
        System.out.println();
        System.out.println("--Congratulations---");
        System.out.println("User: " + user.getName() + " added");
    }

}
