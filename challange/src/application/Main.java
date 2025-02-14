package application;

import user.UserMenu;

import javax.naming.InvalidNameException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidNameException {
        UserMenu.userMenuOptions();
    }
}
