package utils;

import javax.naming.InvalidNameException;

public class NameValidator {
    public static void nameValidator(String name) throws InvalidNameException {
        String[] nameSplit = name.split(" ");
        if((name.length() - nameSplit.length + 1 >= 10)){
            throw new InvalidNameException("Please,THE LENGTH OF CHARACTERS NEEDS TO BE 10 OR MORE");
        }
    }
}
