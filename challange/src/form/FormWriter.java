package form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormWriter {
    private static List<String> questions = new ArrayList<>();

    public static void addQuestionToForm() {
        int questionsSize = questions.size() + 4;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the question: ");
        String question = scanner.nextLine();
        questions.add(question);

        File file = new File("src/resources/forms.txt");
        try (FileWriter fw = new FileWriter(file,true);
             BufferedWriter bw = new BufferedWriter(fw)) {
                questionsSize += 1;
                bw.write("\n" + questionsSize + "- " + question);
                bw.flush();;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeQuestionToForm(){
        FormReader.formReader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number from the question that you´d like to remove: ");
        int questionRemoved = scanner.nextInt();
    }
}
