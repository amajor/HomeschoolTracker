package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class IsNotPreparedState implements State {
    private final Lesson lesson;

    public IsNotPreparedState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String getStateDescription() {
        return ("Materials have not been prepared for this lesson.");
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
