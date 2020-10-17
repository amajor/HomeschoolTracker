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

    public void add(Student student) {
        studentArrayList.add(student);
    }

    public Student getChild(int position) {
        return studentArrayList.get(position);
    }

    public void print() {
        System.out.println("\nParent: " + getName());
    }
}
