package form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        String texto = "Italo Cezar Eugênio de Santana";
        String[] partes = texto.split(" ");
        String concatenando = "";

        if(partes.length >= 2){
            String firstName = partes[0];
            String secondName = partes[1];

           concatenando  = firstName.toUpperCase() + secondName.toUpperCase();

        }
        System.out.println(concatenando);

        File file = new File(concatenando + ".txt");

        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(texto);
            bw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
