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

        Form form1 = new Form("1");
        Form form2 = new Form("2");
        Form form3 = new Form("3");

        System.out.println("contorul " + Form.getCounter());
    }
}
