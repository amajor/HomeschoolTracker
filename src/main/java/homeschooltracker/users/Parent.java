/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.users;

import homeschooltracker.content.Task;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is a class for the Parent user.
 * @author Alison Major
 */
public class Parent {
    private String name;
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    /**
     * The constructor for the {@code Parent} class.
     * @param name The name of the parent
     */
    public Parent(String name)
    {
        this.name = name;
    }

    /**
     * Gets the {@code Parent}'s name.
     * @return The name of the parent.
     */
    public String getName() {
        return name;
    }

    /**
     * Add's a {@code Student} to the {@code Parent}.
     * @see homeschooltracker.users.Student
     * @see homeschooltracker.users.Student
     * @param student The {@code Student} belonging to the {@code Parent}.
     */
    public void add(Student student) {
        studentArrayList.add(student);
    }

    /**
     * Gets a {@code Student} from a specific position in the ArrayList.
     * @param position The position in the ArrayList of a {@code Parent}'s students.
     * @return The {@code Student} from the position given.
     * @see homeschooltracker.users.Student
     */
    public Student getChild(int position) {
        return studentArrayList.get(position);
    }

    /**
     * Gets the number of {@code Student}s that belong to this {@code Parent}.
     * @return An integer of the {@code Student} count.
     * @see homeschooltracker.users.Student
     */
    public int getNumberOfChildren() {
        return this.studentArrayList.size();
    }

    /**
     * Prints the name of the {@code Parent}.
     */
    public void print() {
        System.out.println("\nParent: " + getName());
    }

    /**
     * Prints the list of tasks nested belonging to the {@code Student}s that belong to the {@code Parent}.
     * @see homeschooltracker.users.Student
     * @see homeschooltracker.content.Task
     */
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

    /**
     * Gets an ArrayList of {@code Student}s that belong to this {@code Parent}.
     * @return An ArrayList of {@code Student}s
     * @see homeschooltracker.users.Student
     */
    public ArrayList<Student> getChildren() {
        return studentArrayList;
    }
}
