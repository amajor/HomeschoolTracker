/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.content;

import java.util.Iterator;

/**
 * This extends the Task class to create a {@code Lesson}, which could contain {@code Material}(s).
 * @author Alison Major
 */
public class Lesson extends Task {
    /**
     * Builds the Lesson with an initialized state.
     * @see homeschooltracker.content.taskState.IsNotPreparedState
     * @see homeschooltracker.content.taskState.CurrentToPrepareState
     * @see homeschooltracker.content.taskState.IsPreparedState
     * @see homeschooltracker.content.taskState.CurrentLessonState
     * @see homeschooltracker.content.taskState.IsCompletedState
     * @see homeschooltracker.content.taskState.IsGradedState
     * @param name The name of the lesson.
     */
    public Lesson(String name)
    {
        // Set default state
        state = isNotPreparedState;
        this.name = name;
    }

    /**
     * Gets the name of the {@code Lesson}.
     * @return The lesson name.
     */
    public String getName() {
        return "LESSON: " + name;
    }

    /**
     * Prints the Lesson and its {@code Material}(s).
     * @see homeschooltracker.content.Material
     */
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