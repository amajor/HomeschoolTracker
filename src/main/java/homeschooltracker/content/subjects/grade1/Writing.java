package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class Writing extends Subject {
    public Writing() {
        name = "Writing, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Writing...",
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Writing Tablet page", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
