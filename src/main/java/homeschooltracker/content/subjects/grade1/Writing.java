package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Material;
import homeschooltracker.content.Subject;

public class Writing extends Subject {
    public Writing() {
        name = "Writing, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Writing..."
        );

        // Add Materials for Lesson 16
        Material task = new Material("Writing Tablet page");
        lesson16.add(task);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
