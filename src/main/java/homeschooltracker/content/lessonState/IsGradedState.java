package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class IsGradedState implements State {
    private final Lesson lesson;

    public IsGradedState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String getStateDescription() {
        return ("All materials have been graded for this lesson.");
    }
}
