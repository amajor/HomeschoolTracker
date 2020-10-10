package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;

public class SpellingPoetry extends Subject {
    public SpellingPoetry() {
        name = "Spelling & Poetry, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Spelling and poetry...",
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Drawing paper and crayons", false);
        lesson16.addMaterial("'Spelling and Poetry 1' p64", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
