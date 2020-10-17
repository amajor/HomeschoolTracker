package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class IsCompletedState implements State {
    private final Lesson lesson;

    public IsCompletedState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String getStateDescription() {
        return ("The materials for this lesson have been completed by the student.");
    }

    @Override
    public boolean showInParentList() {
        return true;
    }

    @Override
    public boolean showInStudentList() {
        return false;
    }
}
