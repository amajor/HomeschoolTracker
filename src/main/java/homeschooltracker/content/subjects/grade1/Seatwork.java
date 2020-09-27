package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class Seatwork extends Subject {
    public Seatwork() {
        name = "Seatwork, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Seatwork 16",
                "See material list. Save Bible Friends (page 9-16) for booklet in Lesson 19.",
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Arithmetic 1, Page 31", false);
        lesson16.addMaterial("Letters and Sounds 1, page 16", false);
        lesson16.addMaterial("Language 1, page 16", false);
        lesson16.addMaterial("Bible Friends, page 13", false);
        lesson16.addMaterial("Count the pens in your mug. Write it on your AR worksheet.", false);
        lesson16.addMaterial("Writing Tablet: see sample from Lesson 15", false);
        lesson16.addMaterial("Draw a picture of your classroom.", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
