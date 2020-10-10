package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class Arithmetic extends Subject {
    public Arithmetic() {
        name = "Arithmetic, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "",
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Objects for counting", false);
        lesson16.addMaterial("Mini Sheet / Scrap Paper", false);
        lesson16.addMaterial("Lesson 16 Speed Drill (p6)", false);
        lesson16.addMaterial("Arithmetic p31-32", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
