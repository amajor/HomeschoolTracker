package homeschooltracker.content;

import java.util.ArrayList;
import java.util.Iterator;

abstract public class Subject extends Task {
    public String name;
    ArrayList<Task> lessonArrayList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void add(Task lesson) {
        lessonArrayList.add(lesson);
    }

    public Task getChild(int position) {
        return lessonArrayList.get(position);
    }

    public void printSubjectName() {
        System.out.println("\nSubject: " + getName());
    }

    public void printChildren() {
        // Create an iterator for the list using iterator() method
        Iterator<Task> iterator = lessonArrayList.iterator();

        // Displaying the values after iterating through the list
        while (iterator.hasNext()) {
            System.out.println("    " + iterator.next());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
