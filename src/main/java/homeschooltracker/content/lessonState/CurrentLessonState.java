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
}