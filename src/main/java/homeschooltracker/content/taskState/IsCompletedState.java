package homeschooltracker.content.taskState;

import homeschooltracker.content.Task;

public class IsCompletedState implements State {
    private final Task task;

    public IsCompletedState(Task task) {
        this.task = task;
    }

    @Override
    public String getStateDescription() {
        return ("The task \"" + task.getName() + "\" has been completed by the student.");
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
        return false;
    }
}
