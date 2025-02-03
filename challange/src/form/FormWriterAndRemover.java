package form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormWriter {
    private static List<String> questions = new ArrayList<>();

    public static void addNewQuestionToForm() {
        int questionsSize = questions.size() + 4;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the question: ");
        String question = scanner.nextLine();
        questions.add(question);
        String path = Paths.get("src", "resources", "forms.txt").toString();
        File file = new File(path);
        try (FileWriter fw = new FileWriter(file,true);
             BufferedWriter bw = new BufferedWriter(fw)) {
                questionsSize += 1;
                bw.write("\n" + questionsSize + "- " + question);
                bw.flush();;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
