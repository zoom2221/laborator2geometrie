package ro.ulbs.collections;

import java.util.List;

public class Student extends Main {
    private String firstName;
    private String lastName;
    private String group;
    private List<Integer> grades;


    public Student(String firstName, String lastName, String group, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.grades = grades;
    }
    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Group: " + group + ", Grades: " + grades;
    }
}
