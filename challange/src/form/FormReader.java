package form;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FormReader {
    public static void formReader() {
        File file = new File("src/resources/forms.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
