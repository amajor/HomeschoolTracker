package homeschooltracker.content.subjects.grade2;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class Bible extends Subject {
    public Bible() {
        name = "Bible, Grade 2";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Memorization: Genesis 1:1-5",
                false
        );

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
