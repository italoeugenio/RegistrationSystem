package application;

import form.FormReader;
import user.User;
import user.UserManager;


public class Main {
    public static void main(String[] args) {
        FormReader.formReader();
        User.userInformations();
    }
}
