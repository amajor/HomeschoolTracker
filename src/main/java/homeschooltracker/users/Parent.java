package homeschooltracker.users;

import java.util.ArrayList;

public class Parent {
    String name;
    ArrayList<Student> studentArrayList = new ArrayList<>();

    public Parent(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    public Student getStudentAtPosition(int position) {
        return studentArrayList.get(position);
    }

    public void printName() {
        System.out.println("\nParent: " + getName());
    }
}
