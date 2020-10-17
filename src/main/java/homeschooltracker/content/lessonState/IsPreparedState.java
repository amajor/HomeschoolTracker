package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class IsPreparedState implements State {
    private final Lesson lesson;

    public IsPreparedState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String getStateDescription() {
        return ("Materials have been prepared for this lesson.");
    }

    @Override
    public boolean showInParentList() {
        return false;
    }

    @Override
    public boolean showInStudentList() {
        return false;
    }
}
