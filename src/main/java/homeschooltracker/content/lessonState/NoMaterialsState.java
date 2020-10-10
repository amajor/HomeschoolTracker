package homeschooltracker.content.lessonState;

import homeschooltracker.content.Lesson;

public class NoMaterialsState implements State {
    private final Lesson lesson;

    public NoMaterialsState(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String getStateDescription() {
        return ("This lesson does not have any materials.");
    }
}
