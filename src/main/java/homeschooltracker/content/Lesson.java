package homeschooltracker.content;

import homeschooltracker.content.taskState.*;

import java.util.Iterator;

public class Lesson extends Task {
    public Lesson(String name)
    {
        isNotPreparedState = new IsNotPreparedState(this);
        currentToPrepareState = new CurrentToPrepareState(this);
        isPreparedState = new IsPreparedState(this);
        currentLessonState = new CurrentLessonState(this);
        isCompletedState = new IsCompletedState(this);
        isGradedState = new IsGradedState(this);

        // Set default state
        state = isNotPreparedState;
        this.name = name;
    }

    public void print() {
        System.out.print("\nLESSON: " + getName());
        System.out.println("---------------------");

        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.print();
        }
    }
}