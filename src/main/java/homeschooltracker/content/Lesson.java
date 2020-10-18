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

    public void setChildPrepared(int position) {
        getChild(position).setPrepared();
        Iterator<Task> iterator = taskArrayList.iterator();
        int numberPrepared = 0;
        while (iterator.hasNext()) {
            Task material = iterator.next();
            if(material.isPrepared()) {
                numberPrepared = numberPrepared + 1;
            }
        }
        if(numberPrepared == taskArrayList.size()) {
            // All the tasks are prepared; set the lesson to prepared as well!
            setState(isPreparedState);
        }
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