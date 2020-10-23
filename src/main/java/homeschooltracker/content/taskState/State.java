/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.content.taskState;

/**
 * An interface for all of the different state options available.
 * @author Alison Major
 */
public interface State {
    /**
     * Returns the description of the state (human-friendly to read).
     * @return A sentence describing the {@code Task} state.
     */
    public String getStateDescription();

    /**
     * Returns a one-word string of the state.
     * @return A camel-cased word describing the state.
     */
    public String getState();

    /**
     * Whether to show in the {@code Parent} task list.
     * @return True or False
     */
    public boolean showInParentList();

    /**
     * Whether to show in the {@code Student} task list.
     * @return True or False
     */
    public boolean showInStudentList();

    /**
     * Whether the task has already been prepared.
     * @return True or False
     */
    public boolean isPrepared();

    /**
     * Whether the task is a current task for the student.
     * @return True or False
     */
    public boolean isCurrent();

    /**
     * Whether the task has already been completed by the student.
     * @return True or False
     */
    public boolean isCompleted();

    /**
     * Whether the task has already been graded by the parent.
     * @return True or False
     */
    public boolean isGraded();
}
