package ro.ulbs.collections;

import java.util.List;
import java.util.Objects;

public class Student extends Main {
    private String firstName;
    private String lastName;
    private String group;
    private List<Integer> grades;

    // Constructor
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

    public String getGroup() {
        return group;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double calculateAverage() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public long countFailures() {
        return grades.stream().filter(grade -> grade < 5).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, group);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Group: " + group + ", Grades: " + grades;
    }
}
