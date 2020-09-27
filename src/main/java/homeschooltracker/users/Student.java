package homeschooltracker.users;

import homeschooltracker.content.Subject;

import java.util.ArrayList;

public class Student {
    String name;
    ArrayList<Subject> subjectArrayList = new ArrayList<>();

    public Student(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        subjectArrayList.add(subject);
    }

    public Subject getSubjectAtPosition(int position) {
        return subjectArrayList.get(position);
    }

    public void printName() {
        System.out.println("\nStudent: " + getName());
    }
}
