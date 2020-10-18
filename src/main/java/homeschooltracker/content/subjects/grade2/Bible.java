package homeschooltracker.content.subjects.grade2;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class Bible extends Subject {
    public Bible() {
        name = "Bible, Grade 2";

        // Build Lesson 16
        Lesson lesson16 = new Lesson("Lesson 16");

        // Add lesson to this subject.
        this.add(lesson16);
    }
}
