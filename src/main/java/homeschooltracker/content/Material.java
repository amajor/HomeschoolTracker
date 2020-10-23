package homeschooltracker.content;

import homeschooltracker.content.taskState.*;

public class Material extends Task {
    public Material(String name)
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

    public String getName() {
        return name;
    }

    public void print() {
        System.out.print("  " + toString() + "\n");
    }
}
