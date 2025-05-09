package ro.ulbs.infiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;


/*public class Files1 {

    public static void main(String[] args) {
        String caleFisier = "input1.txt";

        try {
            byte[] bytes = Files.main(Paths.get(caleFisier));
            String continut = new String(bytes);

            String[] linii = continut.split("\\r?\\n");
            StringBuilder sirModificat = new StringBuilder();

            for (String linie : linii) {
                for (char caracter : linie.toCharArray()) {
                    sirModificat.append(caracter);
                    if (caracter == '.') {
                        sirModificat.append('\n');
                    }
                }
                sirModificat.append('\n');
            }

            System.out.println(sirModificat.toString());

        } catch (IOException e) {
            System.err.println("Eroare  " + e.getMessage());
        }
    }
}*/


