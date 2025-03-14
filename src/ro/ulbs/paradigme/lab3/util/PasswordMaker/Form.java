package ro.ulbs.paradigme.lab3.util.PasswordMaker;

public class Form {
    private static int counter = 0;
    private String name;


    public Form(String name) {
        this.name = name;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Form form1 = new Form("Form1");
        Form form2 = new Form("Form2");
        Form form3 = new Form("Form3");

        System.out.println("Numărul total de instanțe create: " + Form.getCounter());
    }
}
