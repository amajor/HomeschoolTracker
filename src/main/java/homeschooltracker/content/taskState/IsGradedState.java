package homeschooltracker.content.taskState;

import homeschooltracker.content.Task;

public class IsGradedState implements State {
    private final Task task;

    public IsGradedState(Task task) {
        this.task = task;
    }

    @Override
    public String getState() {
        return "isGraded";
    }

    @Override
    public String getStateDescription() {
        return ("The task \"" + task.getName() + "\" has been graded.");
    }

    @Override
    public boolean showInParentList() {
        return false;
    }

    @Override
    public boolean showInStudentList() {
        return false;
    }

    @Override
    public boolean isPrepared() {
        return true;
    }

    @Override
    public boolean isCurrent() {
        return false;
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

    @Override
    public boolean isGraded() {
        return true;
    }
}
