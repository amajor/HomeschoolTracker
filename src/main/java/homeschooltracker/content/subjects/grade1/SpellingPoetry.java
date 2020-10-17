package homeschooltracker.content.subjects.grade1;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Material;
import homeschooltracker.content.Subject;

public class SpellingPoetry extends Subject {
    public SpellingPoetry() {
        name = "Spelling & Poetry, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "Spelling and poetry..."
        );

        // Add Materials for Lesson 16
        Material task1 = new Material("Drawing paper and crayons");
        lesson16.add(task1);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
