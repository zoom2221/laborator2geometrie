package ro.ulbs.infiles;

import java.io.*;

public class Files {
    public static void main(String[] args) {
        String filePath = "input1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line + "\n\n");
            }
        } catch (IOException e) {
            System.err.println("Eroare " + e.getMessage());
        }
    }

}