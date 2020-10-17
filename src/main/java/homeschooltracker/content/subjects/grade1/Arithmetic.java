package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Material;
import homeschooltracker.content.Subject;

public class Arithmetic extends Subject {
    public Arithmetic() {
        name = "Arithmetic, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                ""
        );

        // Add Materials for Lesson 16
        Material task1 = new Material("Objects for counting");
        lesson16.add(task1);

        Material task2 = new Material("Mini Sheet / Scrap Paper");
        lesson16.add(task2);

        Material task3 = new Material("Lesson 16 Speed Drill (p6)");
        lesson16.add(task3);

        Material task4 = new Material("Arithmetic p31-32");
        lesson16.add(task4);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
