package org.example.Sorting;

import java.util.*;

class Student {
  private String name;
  private int age;
  private double grade;

  public Student(String name, int age, double grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getGrade() {
    return grade;
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", grade=" + grade +
            '}';
  }
}

public class Main {
  public static void main(String[] args) {
    // Create a list of Student objects
    List<Student> students = new ArrayList<>();
    students.add(new Student("Alice", 20, 85.5));
    students.add(new Student("Bob", 22, 78.2));
    students.add(new Student("Charlie", 21, 90.0));

    // Prompt user for sorting criteria
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter field(s) by which you want to sort (name, age, grade):");
    String[] fields = scanner.nextLine().split("\\s+");

    // Sort the list based on user-specified fields
    Collections.sort(students, new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        for (String field : fields) {
          switch (field) {
            case "name":
              int nameCompare = s1.getName().compareTo(s2.getName());
              if (nameCompare != 0)
                return nameCompare;
              break;
            case "age":
              int ageCompare = Integer.compare(s1.getAge(), s2.getAge());
              if (ageCompare != 0)
                return ageCompare;
              break;
            case "grade":
              int gradeCompare = Double.compare(s1.getGrade(), s2.getGrade());
              if (gradeCompare != 0)
                return gradeCompare;
              break;
            default:
              System.out.println("Invalid field: " + field);
              break;
          }
        }
        return 0;
      }
    });

    // Print the sorted list of students
    System.out.println("Sorted List of Students:");
    for (Student student : students) {
      System.out.println(student);
    }
  }
}
