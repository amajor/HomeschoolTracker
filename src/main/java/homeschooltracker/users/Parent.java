package homeschooltracker.users;

import homeschooltracker.content.Task;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void printTasks() {
        System.out.println("\n TODO LIST FOR " + getName());
        System.out.println("==========================================");

        Iterator<Student> iterator = studentArrayList.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("\n|  PREPARE/GRADE ITEMS FOR " + student.getName());
            System.out.println("------------------------------------------");

            ArrayList<Task> subjects = student.getTaskArrayList();
            subjects.forEach(
                (subject) -> subject.printParentTasks()
            );
        }
    }

    public ArrayList<Student> getChildren() {
        return studentArrayList;
    }
}
