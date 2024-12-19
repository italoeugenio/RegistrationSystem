package application;

import form.FormReader;
import user.User;
import utils.AgeValidator;

public class Main {
    public static void main(String[] args) {
        FormReader.formReader();
        User.userInformations();
    }
}
