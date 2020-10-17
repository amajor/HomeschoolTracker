package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class Combination extends Subject {
    public Combination() {
        name = "Combination, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Combinations...",
                false,
                false,
                false
        );

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
