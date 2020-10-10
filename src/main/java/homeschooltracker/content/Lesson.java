package homeschooltracker.content;

import homeschooltracker.content.lessonState.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Lesson {
    State isPreparedState;
    State noMaterialsState;
    State isCompletedState;
    State isGradedState;
    State isNotPreparedState;

    State state;

    String name;
    String description;
    boolean completed;
    ArrayList<Material> materialArrayList = new ArrayList<>();

    public Lesson(
            String name,
            String description,
            boolean completed
    )
    {
        noMaterialsState = new NoMaterialsState(this);
        isNotPreparedState = new IsNotPreparedState(this);
        isPreparedState = new IsPreparedState(this);
        isCompletedState = new IsCompletedState(this);
        isGradedState = new IsGradedState(this);


        if (materialArrayList.isEmpty()) {
            state = noMaterialsState;
        } else {
            state = isPreparedState;
        }
        this.name = name;
        this.description = description;
        this.completed = completed;
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

    public boolean isCompleted() {
        return completed;
    }

    public boolean isUnfinished() {
        return !completed;
    }

    public void markCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        String check = " ";
        if (completed) {
            check = "X";
        }
        return ("  [" + check + "] " + name + " - " + description);
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
        return state.stateDescription();
    }

    public void printState() {
        System.out.println(getStateDescription());
    }
}