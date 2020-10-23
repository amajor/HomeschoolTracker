package homeschooltracker.content;

import java.util.Iterator;

public class Lesson extends Task {
    public Lesson(String name)
    {
        // Set default state
        state = isNotPreparedState;
        this.name = name;
    }

    public String getName() {
        return "LESSON: " + name;
    }

    public void print() {
        System.out.println(toString());

        Iterator<Task> iterator = taskArrayList.iterator();
        if(iterator.hasNext()) {
            System.out.println("\n    MATERIALS:");
        }
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.print();
        }
    }
}