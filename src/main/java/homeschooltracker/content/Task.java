/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.content;

import homeschooltracker.content.taskState.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An abstract class that forms a Task. The {@code Subject}, {@code Lesson}, and {@code Material} classes extend this.
 * @see homeschooltracker.content.Subject
 * @see homeschooltracker.content.Lesson
 * @see homeschooltracker.content.Material
 */
public abstract class Task {
    public String name;
    public ArrayList<Task> taskArrayList = new ArrayList<>();

    State isNotPreparedState = new IsNotPreparedState(this);
    State currentToPrepareState = new CurrentToPrepareState(this);
    State isPreparedState = new IsPreparedState(this);
    State currentLessonState = new CurrentLessonState(this);
    State isCompletedState = new IsCompletedState(this);
    State isGradedState = new IsGradedState(this);

    State state;

    /**
     * Adds another {@code Task} to this {@code Task}. For example, a {@code Subject Task} might contain
     * one or more {@code Lesson Task}(s). A {@code Lesson Task} might contain one or more {@code Material Task}(s).
     * @param task The task to add to this task.
     */
    public void add(Task task) {
        if(taskArrayList.size() == 0) {
            task.setState(currentToPrepareState);
        }
        taskArrayList.add(task);
    }

    /**
     * Gets the {@code Task} from a specific position.
     * @param position The position to get the {@code Task} from.
     * @return The {@code Task} from the position.
     */
    public Task getChild(int position) {
        if(taskArrayList.size() == 0) {
            throw new UnsupportedOperationException();
        }
        return taskArrayList.get(position);
    }

    /**
     * Gets the name of the {@code Task}.
     * @return The name of the {@code Task}.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the state for this {@code Task}.
     * @see homeschooltracker.content.taskState.State
     * @param state The state of the {@code Task}.
     */
    void setState(State state) {
        this.state = state;
        setChildrenState(state);
    }

    /**
     * Sets the state for all of the children {@code Task}s of this {@code Task}.
     * @see homeschooltracker.content.taskState.IsNotPreparedState
     * @see homeschooltracker.content.taskState.CurrentToPrepareState
     * @see homeschooltracker.content.taskState.IsPreparedState
     * @see homeschooltracker.content.taskState.CurrentLessonState
     * @see homeschooltracker.content.taskState.IsCompletedState
     * @see homeschooltracker.content.taskState.IsGradedState
     * @param state The desired {@code State} for the children {@code Task}s.
     */
    void setChildrenState(State state) {
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.setState(state);
        }
    }

    /**
     * Gets whether this {@code Task} state to the {@code IsPreparedState}
     * @see homeschooltracker.content.taskState.IsPreparedState
     * @return True if the {@code Task} has been prepared; False if it has not.
     */
    public boolean isPrepared() {
        return state.isPrepared();
    }

    /**
     * Gets the child {@code Task} where the state is {@code IsCurrentState}
     * @see homeschooltracker.content.taskState.CurrentLessonState
     * @return The current task.
     */
    public Task getCurrentTask() {
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.isCurrent()) {
                return task;
            }
        }
        return null;
    }

    /**
     * Sets the {@code Task} state to {@code IsPreparedState}
     * @see homeschooltracker.content.taskState.IsPreparedState
     */
    public void setPrepared() {
        if(getCurrentTask() == null) {
            setState(currentLessonState);
        } else {
            setState(isPreparedState);
        }
    }

    /**
     * Gets whether this {@code Task} state to the {@code CurrentLessonState}
     * @see homeschooltracker.content.taskState.CurrentLessonState
     * @return True if the {@code Task} is a current lesson; False if it has not.
     */
    public boolean isCurrent() {
        return state.isCurrent();
    }

    /**
     * Gets whether this {@code Task} state to the {@code IsCompletedState}
     * @see homeschooltracker.content.taskState.IsCompletedState
     * @return True if the {@code Task} is completed; False if it has not.
     */
    public boolean isCompleted() {
        return state.isCompleted();
    }

    /**
     * Sets the {@code Task} state to {@code IsCompletedState}
     * @see homeschooltracker.content.taskState.IsCompletedState
     */
    public void setCompleted() {
        setState(isCompletedState);
    }

    /**
     * Gets whether this {@code Task} state to the {@code IsGradedState}
     * @see homeschooltracker.content.taskState.IsGradedState
     * @return True if the {@code Task} is graded; False if it has not.
     */
    public boolean isGraded() {
        return state.isGraded();
    }

    /**
     * Sets the {@code Task} state to {@code IsGradedState}
     * @see homeschooltracker.content.taskState.IsGradedState
     */
    public void setGraded() {
        setState(isGradedState);
    }

    /**
     * Gets the description of the current {@code Task}.
     * @see State#getStateDescription()
     * @return The description of the current {@code State}.
     */
    public String getStateDescription() {
        return state.getStateDescription();
    }

    /**
     * Gets the current {@code State} for this {@code Task}.
     * @return A one-word label for the current state.
     */
    public String getState() {
        return state.getState();
    }

    /**
     * Whether or not the {@code Task} should show in the {@code Parent} list.
     * @return True if the {@code Task} should show in the {@code Parent} list.
     */
    public boolean showInParentList() {
        return state.showInParentList();
    };

    /**
     * Whether or not the {@code Task} should show in the {@code Student} list.
     * @return True if the {@code Task} should show in the {@code Student} list.
     */
    public boolean showInStudentList() {
        return state.showInStudentList();
    }

    /**
     * Forms a string of to-do list task for the user.
     * Has 3 checkboxes for whether an item is prepared (by {@code Parent}), completed (by {@code Student}),
     * or graded (by {@code Parent}).
     * @return A formatted string of the task.
     */
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
        return ("  [" + prepared + "][" + completed + "][" + graded + "] " + getName());
    }

    /**
     * Prints the task string.
     */
    public void print() {
        System.out.println(this.toString());
    }

    /**
     * Prints the child tasks that belong to this Task.
     * @param taskArrayList The ArrayList of Tasks.
     */
    void printTasks(ArrayList<Task> taskArrayList) {
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            try {
                System.out.println(task.toString());
                task.printParentTasks();
            }
            catch(Exception e) {
                System.out.println("  --> There are no tasks! " + e);
            }
        }
    }

    /**
     * Prints a list of the parent tasks.
     */
    public void printParentTasks() {
        printTasks(getParentTaskArrayList());
    }

    /**
     * Printsa list of the student tasks.
     */
    public void printStudentTasks() {
        printTasks(getStudentTaskArrayList());
    }

    /**
     * Gets an array of the child tasks.
     * @return The ArrayList of any child tasks.
     */
    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    /**
     * Gets the ArrayList of tasks for the {@code Parent}.
     * @see homeschooltracker.users.Parent
     * @return An ArrayList of the {@code Parent} user type.
     */
    public ArrayList<Task> getParentTaskArrayList() {
        ArrayList<Task> parentTaskArrayList = new ArrayList<>();
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.showInParentList()) {
                parentTaskArrayList.add(task);
            }
        }
        return parentTaskArrayList;
    }

    /**
     * Gets the ArrayList of tasks for the {@code Student}.
     * @see homeschooltracker.users.Student
     * @return An ArrayList of the {@code Student} user type.
     */
    public ArrayList<Task> getStudentTaskArrayList() {
        ArrayList<Task> studentTaskArrayList = new ArrayList<>();
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.showInStudentList()) {
                studentTaskArrayList.add(task);
            }
        }
        return studentTaskArrayList;
    }
}
