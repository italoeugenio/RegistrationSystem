package form;

import java.io.*;

public class FormWriter {
    public static void main(String[] args) {
        File file = new File("/Users/italo/Documents/RegistrationSystem/challange/src/registrations/teste.txt");
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("teste");
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
