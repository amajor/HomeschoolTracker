package homeschooltracker.content;

import java.util.Iterator;

abstract public class Subject extends Task {
    public void print() {
        System.out.print("\nSUBJECT: " + getName());
        System.out.println("---------------------");

        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.print();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
