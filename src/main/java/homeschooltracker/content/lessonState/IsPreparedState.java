package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class IsPreparedState implements State {
    private final Lesson lesson;

    public IsPreparedState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String stateDescription() {
        return ("Materials have been prepared for this lesson.");
    }
}
