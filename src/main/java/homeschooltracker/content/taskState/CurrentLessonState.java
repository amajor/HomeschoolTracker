package homeschooltracker.content.taskState;

import homeschooltracker.content.Task;

public class CurrentLessonState implements State {
    private final Task task;

    public CurrentLessonState(Task task) {
        this.task = task;
    }

    @Override
    public String getStateDescription() {
        return ("This task \"" + task.getName() + "\" is in progress by the student.");
    }

    @Override
    public boolean showInParentList() {
        return false;
    }

    @Override
    public boolean showInStudentList() {
        return true;
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
