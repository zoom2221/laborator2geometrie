package ro.ulbs.Unit;

public class Unit {

    private int state;


    public Unit(int state) {
        this.state = state;
    }


    public Unit add(int value) {
        this.state += value;
        return this;
    }


    public Unit subtract(int value) {
        this.state -= value;
        return this;
    }


    public Unit multiply(int value) {
        this.state *= value;
        return this;
    }


    public int result() {
        return this.state;
    }


    public Unit clear() {
        this.state = 0;
        return this;
    }
}