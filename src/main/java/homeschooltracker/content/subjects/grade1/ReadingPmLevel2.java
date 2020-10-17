package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Material;
import homeschooltracker.content.Subject;

public class ReadingPmLevel2 extends Subject {
    public ReadingPmLevel2() {
        name = "Reading PM 2, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson("Lesson 16");

        // Add Materials for Lesson 16
        Material task1 = new Material("Handbook for Reading");
        lesson16.add(task1);
        Material task2 = new Material("Read 'Handbook for Reading' p26-27 to parent.");
        lesson16.add(task2);
        Material task3 = new Material("Read 'Fun with Pets' p34-35 to parent.");
        lesson16.add(task3);

        // Add lesson to this subject.
        this.add(lesson16);
    }
}
