package Experiment5;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<String> Students = new ArrayList<String>();
    private int numberOfStudents = 0;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        Students.add(student);
        numberOfStudents++;
    }

    public void getStudents() {
        for (String student : Students){
            System.out.println(student);
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        for (String s :Students){
            if (student.equals(s)){
                Students.remove(student);
                numberOfStudents--;
                System.out.println("Removed student：" + student);
            }
            else{
                System.out.println("Cannot remove student："+ student );
            }
        }
    }

    public static void main(String[] args) {
        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Database Systems");

        course1.addStudent("Peter Jones");
        course1.addStudent("Brian Smith");
        course1.addStudent("Anne Kennedy");

        course2.addStudent("Peter Jones");
        course2.addStudent("Steve Smith");

        System.out.println("Number of students in course1: "
                + course1.getNumberOfStudents());
        course1.getStudents();

        System.out.println();
        System.out.print("Number of students in course2: "
                + course2.getNumberOfStudents());
    }
}

