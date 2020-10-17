package homeschooltracker.users;

import homeschooltracker.content.Subject;
import homeschooltracker.content.Task;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
    String name;
    ArrayList<Task> taskArrayList = new ArrayList<>();

    public Student(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Subject subject) {
        taskArrayList.add(subject);
    }

    public Task getChild(int position) {
        return taskArrayList.get(position);
    }

    public void print() {
        System.out.println("\nStudent: " + getName());
    }

    public void printTasks() {
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.print();
        }
    }
}
