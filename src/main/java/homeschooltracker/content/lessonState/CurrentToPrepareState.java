package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class CurrentToPrepareState implements State {
    private final Lesson lesson;

    public CurrentToPrepareState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String getStateDescription() {
        return ("This lesson is being prepared by the parent.");
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
