package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class ReadingAmLevel2 extends Subject {
    public ReadingAmLevel2() {
        name = "Reading AM 2, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "This is lesson 16 for Grade 1, Reading level 2.",
                false,
                false,
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Fun with Pets", false);
        lesson16.addMaterial("Read 'Fun with Pets' p28-33 to parent.", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
