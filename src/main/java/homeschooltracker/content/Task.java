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
}
