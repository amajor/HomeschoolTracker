package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class Bible extends Subject {
    public Bible() {
        name = "Bible, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Memorization: John 3:14-19",
                false,
                false,
                false
        );

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
