package homeschooltracker.content;

import java.util.Iterator;

abstract public class Subject extends Task {
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

    @Override
    public String toString() {
        return name;
    }
}
