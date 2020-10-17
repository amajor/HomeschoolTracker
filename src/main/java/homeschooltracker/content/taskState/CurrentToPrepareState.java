package homeschooltracker.content.taskState;

import homeschooltracker.content.Task;

public class CurrentToPrepareState implements State {
    private final Task task;

    public CurrentToPrepareState(Task task) {
        this.task = task;
    }

    @Override
    public String getStateDescription() {
        return ("This task is being prepared by the parent.");
    }

    @Override
    public boolean showInParentList() {
        return true;
    }

    @Override
    public boolean showInStudentList() {
        return false;
    }

    @Override
    public boolean isPrepared() {
        return false;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public boolean isGraded() {
        return false;
    }
}