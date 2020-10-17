package homeschooltracker.content;

import homeschooltracker.content.taskState.State;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Task {
    public String name;
    public ArrayList<Task> taskArrayList = new ArrayList<>();

    State isNotPreparedState;
    State currentToPrepareState;
    State isPreparedState;
    State currentLessonState;
    State isCompletedState;
    State isGradedState;

    State state;

    public void add(Task task) {
        taskArrayList.add(task);
    }

    public void remove(Task task) {
        throw new UnsupportedOperationException();
    }

    public Task getChild(int position) {
        if(taskArrayList.size() == 0) {
            throw new UnsupportedOperationException();
        }
        return taskArrayList.get(position);
    }

    public String getName() {
        return name;
    }

    void setState(State state) {
        this.state = state;
    }

    public boolean isPrepared() {
        return state.isPrepared();
    }

    public void setPrepared() {
        setState(isPreparedState);

        // Set any children to the same state as the parent!
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.setState(isPreparedState);
        }
    }

    public boolean isCompleted() {
        return state.isCompleted();
    }

    public void setCompleted() {
        setState(isCompletedState);

        // Set any children to the same state as the parent!
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.setState(isCompletedState);
        }
    }

    public boolean isGraded() {
        return state.isGraded();
    }

    public void setGraded() {
        setState(isGradedState);

        // Set any children to the same state as the parent!
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.setState(isGradedState);
        }
    }

    public String getStateDescription() {
        return state.getStateDescription();
    }

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

    public void print() {
        System.out.println(this.toString());
    }
}
