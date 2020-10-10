package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class IsNotPreparedState implements State {
    private final Lesson lesson;

    public IsNotPreparedState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String stateDescription() {
        return ("Materials have not been prepared for this lesson.");
    }
}
