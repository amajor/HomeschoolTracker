package homeschooltracker.content;

import homeschooltracker.content.taskState.State;

public abstract class Task {
    String name;

    State isNotPreparedState;
    State currentToPrepareState;
    State isPreparedState;
    State currentLessonState;
    State isCompletedState;
    State isGradedState;

    State state;

    public void add(Task task) {
        throw new UnsupportedOperationException();
    }

    public void remove(Task task) {
        throw new UnsupportedOperationException();
    }

    public Task getChild(int i) {
        throw new UnsupportedOperationException();
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

    public String getStateDescription() {
        return state.getStateDescription();
    }

    public void printState() {
        System.out.println(getStateDescription());
    }

    public void printChildren() {
        System.out.println(getStateDescription());
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
}
