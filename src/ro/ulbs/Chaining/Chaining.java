package ro.ulbs.Chaining;

public class Chaining {

    private int state;


    public Chaining(int state) {
        this.state = state;
    }


    public Chaining add(int value) {
        this.state += value;
        return this;
    }


    public Chaining subtract(int value) {
        this.state -= value;
        return this;
    }


    public Chaining multiply(int value) {
        this.state *= value;
        return this;
    }


    public int result() {
        return this.state;
    }


    public Chaining clear() {
        this.state = 0;
        return this;
    }


    public static void main(String[] args) {
        Chaining calculator = new Chaining(10);


        int result = calculator.add(5).subtract(3).multiply(2).result();

        System.out.println("a) " + result);


        result = calculator.clear().add(10).multiply(3).result();
        System.out.println("b) " + result);
    }
}
