package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class PhonicsLanguage extends Subject {
    public PhonicsLanguage() {
        name = "Phonics / Language, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Memorization: John 3:14-19\nLesson: Cumulative Review",
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Mini Sheet / Scrap Paper", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
