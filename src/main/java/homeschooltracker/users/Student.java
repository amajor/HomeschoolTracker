package homeschooltracker.users;

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

    public void add(Task subject) {
        taskArrayList.add(subject);
    }

    public Task getChild(int position) {
        return taskArrayList.get(position);
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void print() {
        System.out.println("\nStudent: " + getName());
    }

    public void printTasks() {
        System.out.println("\n TODO LIST FOR " + getName());
        System.out.println("==========================================");

        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task subject = iterator.next();
            ArrayList<Task> tasks = subject.getStudentTaskArrayList();
            if(tasks.size() > 0) {
                System.out.println("\n" + subject.getName());
            }
            tasks.forEach(
                (task) -> task.printStudentTasks()
            );
        }
    }
}
