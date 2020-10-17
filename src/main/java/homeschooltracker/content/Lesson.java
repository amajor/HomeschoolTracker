package homeschooltracker.content;

import homeschooltracker.content.lessonState.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Lesson {
    State isNotPreparedState;
    State currentToPrepareState;
    State isPreparedState;
    State currentLessonState;
    State isCompletedState;
    State isGradedState;

    State state;

    String name;
    String description;
    ArrayList<Material> materialArrayList = new ArrayList<>();

    public Lesson(
            String name,
            String description,
            boolean prepared,
            boolean completed,
            boolean graded
    )
    {
        isNotPreparedState = new IsNotPreparedState(this);
        currentToPrepareState = new CurrentToPrepareState(this);
        isPreparedState = new IsPreparedState(this);
        currentLessonState = new CurrentLessonState(this);
        isCompletedState = new IsCompletedState(this);
        isGradedState = new IsGradedState(this);

        state = isNotPreparedState;

        this.name = name;
        this.description = description;
    }

    public void addMaterial(String description, Boolean graded) {
        Material material = new Material(description, graded);
        materialArrayList.add(material);
        setState(isNotPreparedState);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Material getMaterialAtPosition(int position) {
        return materialArrayList.get(position);
    }

    public boolean isPrepared() {
        return state.isPrepared();
    }

    public void setPrepared() {
        setState(isPreparedState);
    }

    public boolean isCompleted() {
        return state.isCompleted();
    }

    public void setCompleted() {
        setState(isCompletedState);
    }

    public boolean isGraded() {
        return state.isGraded();
    }

    public void setGraded() {
        setState(isGradedState);
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

    public void printLessonName() {
        System.out.println("\nLesson: " + getName());
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

    void setState(State state) {
        this.state = state;
    }

    public String getStateDescription() {
        return state.getStateDescription();
    }

    public void printState() {
        System.out.println(getStateDescription());
    }
}