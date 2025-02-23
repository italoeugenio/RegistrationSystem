package form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import form.FormWriterAndRemover;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormWriterAndRemover {
    private static final List<String> questions = new ArrayList<>();

    public static List<String> getQuestions() {
        return questions;
    }

    public static void addNewQuestionToForm() {
        int questionsSize = questions.size() + 4;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the question: ");
        String question = scanner.nextLine();
        questions.add(question);
        Path path = Path.of("src", "resources", "forms.txt");
        File file = path.toFile();
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            questionsSize += 1;
            bw.write("\n" + questionsSize + "- " + question);
            bw.flush();
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        FormReader.formReader();
        System.out.println();
    }

    public static void removeQuestionToForm() {
        System.out.println();
        FormReader.formReader();

        int questionsSize = questions.size() + 4;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number from the question that you´d like to remove: ");
        int questionRemoved = scanner.nextInt();
        if(questions.isEmpty()){
            System.out.println("You can´t remove the 4 first questions that already was in the form or question that don't exist");
            System.out.println();
            return;
        }
        while (questionRemoved <= 4) {
            System.out.print("You can´t remove the 4 first questions that already was in the form:");
            questionRemoved = scanner.nextInt();
        }

        questions.remove(questionRemoved - 5);

        Path path = Path.of("src", "resources", "forms.txt");
        File file = path.toFile();
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1- What is your full name?\n");
            bw.write("2- What is your email address?\n");
            bw.write("3- How old are you?\n");
            bw.write("4- How tall are you?");
            for (int i = 0; i < questions.size(); i++) {
                bw.write("\n" + (i + 5) + "- " + questions.get(i));
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FormReader.formReader();
        System.out.println();
    }

    public static void rewritingQuestions(){
        Path path = Path.of("src", "resources", "forms.txt");
        File file = path.toFile();
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1- What is your full name?\n");
            bw.write("2- What is your email address?\n");
            bw.write("3- How old are you?\n");
            bw.write("4- How tall are you?");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FormReader.formReader();
        System.out.println();
    }
}
