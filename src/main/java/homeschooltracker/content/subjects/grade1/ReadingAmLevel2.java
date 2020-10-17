package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Material;
import homeschooltracker.content.Subject;

public class ReadingAmLevel2 extends Subject {
    public ReadingAmLevel2() {
        name = "Reading AM 2, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson("Lesson 16");

        // Add Materials for Lesson 16
        Material task1 = new Material("Fun with Pets");
        lesson16.add(task1);
        Material task2 = new Material("Read 'Fun with Pets' p28-33 to parent.");
        lesson16.add(task2);

        // Add lesson to this subject.
        this.add(lesson16);
    }
}
