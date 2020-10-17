package homeschooltracker.content;

import homeschooltracker.content.taskState.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Lesson extends Task {
    String name;
    String description;
    ArrayList<Material> materialArrayList = new ArrayList<>();

    public Lesson(
        String name,
        String description
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
        this.description = description;
    }

    public void add(Material task) {
        materialArrayList.add(task);
        // setState(isNotPreparedState);
    }

    public String getDescription() {
        return description;
    }

    public Task getChild(int position) {
        return materialArrayList.get(position);
    }

    @Override
    public String toString() {
        String prepared = " ";
        String completed = " ";
        String graded = " ";
        if (isPrepared()) {
            prepared = "X";
        }
        if (isCompleted()) {
            completed = "X";
        }
        if (isGraded()) {
            graded = "X";
        }
        return ("  [" + prepared + "][" + completed + "][" + graded + "] " + name + " - " + description);
    }

    public void printMaterialList() {
        // Create an iterator for the list using iterator() method
        Iterator<Material> iterator = materialArrayList.iterator();

        // Displaying the values after iterating through the list
        if (iterator.hasNext()) {
            System.out.println("        Materials: ");
        }
        while (iterator.hasNext()) {
            System.out.println("        " + iterator.next());
        }
    }
}