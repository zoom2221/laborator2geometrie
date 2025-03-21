package ro.ulbs.collections;

import java.io.*;
import java.util.*;

public class Main  {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" ");
                String firstName = parts[0];
                String lastName = parts[1];
                String group = parts[2];
                List<Integer> grades = new ArrayList<>();

                for (int i = 3; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }


                Student student = new Student(firstName, lastName, group, grades);


                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        students.sort(Comparator.comparing(Student::getGroup)
                .thenComparing(Student::getLastName)
                .thenComparing(Student::getFirstName));

        System.out.println("Studenți ordonați alfabetic, pe grupe:");
        students.forEach(System.out::println);


        students.sort(Comparator.comparing(Student::calculateAverage).reversed());

        System.out.println("\nStudenți ordonați descrescător după medii:");
        students.forEach(System.out::println);


        students.sort(Comparator.comparing(Student::countFailures));

        System.out.println("\nStudenți ordonați crescător după numărul de restanțe:");
        students.forEach(System.out::println);


        Map<Student, Integer> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student, studentMap.getOrDefault(student, 0) + 1);
        }


        System.out.println("\nde cate ori a aparut studentul:");
        studentMap.forEach((student, count) -> System.out.println(student + ", Apariții: " + count));
    }
}
