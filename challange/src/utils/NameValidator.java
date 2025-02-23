package utils;

import javax.naming.InvalidNameException;

public class NameValidator {
    public static boolean nameValidator(String name) {
        try {
            String[] nameSplit = name.split(" ");
            if ((name.length() - nameSplit.length + 1 <= 10)) {
                throw new InvalidNameException("Please,THE LENGTH OF NAME NEEDS TO BE 10 OR MORE");
            }
            return true;

        } catch (InvalidNameException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }
}
