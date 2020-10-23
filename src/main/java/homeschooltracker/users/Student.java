/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.users;

import homeschooltracker.content.Task;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is a class for the Student user.
 * @author Alison Major
 */
public class Student {
    private String name;
    private ArrayList<Task> taskArrayList = new ArrayList<>();

    /**
     * The constructor for the {@code Student} class.
     * @param name The name of the student
     */
    public Student(String name)
    {
        this.name = name;
    }

    /**
     * Gets the student's name.
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a subject to the student.
     * @see homeschooltracker.content.Subject
     * @param subject
     */
    public void add(Task subject) {
        taskArrayList.add(subject);
    }

    /**
     * Gets a subject from a specific position in the ArrayList.
     * @param position The position in the {@code ArrayList} of a Student's subjects.
     * @return The {@code Subject} from the position given.
     */
    public Task getChild(int position) {
        return taskArrayList.get(position);
    }

    /**
     * Gets all of the subjects belonging to a {@code Student}.
     * @see homeschooltracker.content.Subject
     * @return An ArrayList of {@code Subject} tasks.
     */
    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    /**
     * Prints the name of the {@code Student}.
     */
    public void print() {
        System.out.println("\nStudent: " + getName());
    }

    /**
     * Prints a list of tasks (subjects) for the {@code Student}.
     */
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
