/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.content;

import java.util.Iterator;

/**
 * This extends the {@code Task} class to create a Subject, which could contain {@code Lesson}(s).
 * @author Alison Major
 */
abstract public class Subject extends Task {
    /**
     * Prints the Subject and its Lessons.
     */
    public void print() {
        System.out.println("\n==========================================");
        System.out.println("  SUBJECT: " + getName());
        System.out.println("------------------------------------------");

        System.out.println("\n  LESSONS:");
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task lesson = iterator.next();
            lesson.print();
        }
    }

    /**
     * Prints the tasks nested under this subject that belong to the {@code Parent}
     * @see homeschooltracker.users.Parent
     */
    public void printParentTasks() {
        System.out.println("\n" + getName() + ":");
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task lesson = iterator.next();
            try {
                if(lesson.showInParentList()) {
                    System.out.println(lesson.toString());
                    lesson.printParentTasks();
                } else {
                    System.out.println("  --> No tasks for parent!");
                }
            }
            catch(Exception e) {
                System.out.println("  --> There are no lessons! " + e);
            }
        }
    }

    /**
     * Builds a string using the Subject name.
     * @return The name of the Subject.
     */
    @Override
    public String toString() {
        return name;
    }
}
