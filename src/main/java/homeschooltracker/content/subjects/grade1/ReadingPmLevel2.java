package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class ReadingPmLevel2 extends Subject {
    public ReadingPmLevel2() {
        name = "Reading PM 2, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "This is lesson 16 for Grade 1, Reading level 2.",
                false,
                false,
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Handbook for Reading", false);
        lesson16.addMaterial("Read 'Handbook for Reading' p26-27 to parent.", false);
        lesson16.addMaterial("Read 'Fun with Pets' p34-35 to parent.", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
