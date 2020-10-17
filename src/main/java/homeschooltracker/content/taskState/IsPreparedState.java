package homeschooltracker.content.taskState;

import homeschooltracker.content.Task;

public class IsPreparedState implements State {
    private final Task task;

    public IsPreparedState(Task task) {
        this.task = task;
    }

    @Override
    public String getStateDescription() {
        return ("The task \"" + task.getName() + "\" has been prepared.");
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
    public boolean isCompleted() {
        return false;
    }

    @Override
    public boolean isGraded() {
        return false;
    }
}
