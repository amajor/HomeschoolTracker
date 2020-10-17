package homeschooltracker.content;

import homeschooltracker.content.taskState.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Lesson extends Task {
    String name;
    ArrayList<Task> materialArrayList = new ArrayList<>();

    public Lesson(
        String name
    )
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

    public void add(Task material) {
        materialArrayList.add(material);
        // setState(isNotPreparedState);
    }

    public String getName() {
        return name;
    }

    public Task getChild(int position) {
        return materialArrayList.get(position);
    }

    public void printChildren() {
        // Create an iterator for the list using iterator() method
        Iterator<Task> iterator = materialArrayList.iterator();

        // Displaying the values after iterating through the list
        if (iterator.hasNext()) {
            System.out.println("        Materials: ");
        }
        while (iterator.hasNext()) {
            System.out.println("        " + iterator.next());
        }
    }
}