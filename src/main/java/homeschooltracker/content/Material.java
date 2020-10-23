/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.content;

import homeschooltracker.content.taskState.*;

/**
 * This extends the {@code Task} class to create a Material.
 * @author Alison Major
 */
public class Material extends Task {
    /**
     * Builds the Material with an initialized {@code State}.
     * @see homeschooltracker.content.taskState.IsNotPreparedState
     * @see homeschooltracker.content.taskState.CurrentToPrepareState
     * @see homeschooltracker.content.taskState.IsPreparedState
     * @see homeschooltracker.content.taskState.CurrentLessonState
     * @see homeschooltracker.content.taskState.IsCompletedState
     * @see homeschooltracker.content.taskState.IsGradedState
     * @param name The name of the Material.
     */
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

    /**
     * Gets the name of the Material.
     * @return The material name.
     */
    public String getName() {
        return name;
    }

    /**
     * Prints the material name.
     */
    public void print() {
        System.out.print("  " + toString() + "\n");
    }
}
