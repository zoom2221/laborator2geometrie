package ro.ulbs.paradigme.lab2;

public class Main {
    public static void main(String[] args) {
        Form form = new Form(" " + "blue");
        System.out.println(form);

        Triangle triangle = new Triangle(" " + "red", 5, 10);
        System.out.println(triangle);

        Circle circle = new Circle(" " + "green", 10);
        System.out.println(circle);

Square square = new Square(" " + "yellow", 10);
        System.out.println(square);

        Triangle t1 = new Triangle("yellow", 3, 5);
        Triangle t2 = new Triangle("yellow", 3, 5);
        System.out.println("Triangles equal: " + t1.equals(t2));
    }
    }