package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class CurrentLessonState implements State {
    private final Lesson lesson;

    public CurrentLessonState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String getStateDescription() {
        return ("This lesson is in progress by the student.");
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
