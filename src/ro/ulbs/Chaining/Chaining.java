package ro.ulbs.Chaining;

public class Chaining {

    private int state;

    // Constructor with one parameter to initialize 'state'
    public Chaining(int state) {
        this.state = state;
    }

    // Method to add a value to 'state' and return the class object (for chaining)
    public Chaining add(int value) {
        this.state += value;
        return this;
    }

    // Method to subtract a value from 'state' and return the class object (for chaining)
    public Chaining subtract(int value) {
        this.state -= value;
        return this;
    }

    // Method to multiply 'state' by a value and return the class object (for chaining)
    public Chaining multiply(int value) {
        this.state *= value;
        return this;
    }

    // Method to return the current value of 'state'
    public int result() {
        return this.state;
    }

    // Method to reset 'state' to 0 and return the class object (for chaining)
    public Chaining clear() {
        this.state = 0;
        return this;
    }

    // Main method to test the chaining
    public static void main(String[] args) {
        Chaining calculator = new Chaining(10);

        // Using the chaining methods as described
        int result = calculator.add(5).subtract(3).multiply(2).result();

        System.out.println("a) " + result); // Expected output: 24

        // Example usage of clear and chaining again
        result = calculator.clear().add(10).multiply(3).result();
        System.out.println("b) " + result); // Expected output: 30
    }
}
