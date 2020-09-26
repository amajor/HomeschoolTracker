package homeschooltracker.content;

public class SubjectGrade1Reading2 extends Subject {
    public SubjectGrade1Reading2() {
        name = "Reading 2, Grade 1";

        // Build Lesson 16
        Lesson lesson16 = new Lesson(
                "Lesson 16",
                "This is lesson 16 for Grade 1, Reading level 2.",
                false
        );

        // Add Materials for Lesson 16
        lesson16.addMaterial("Material 1", false);
        lesson16.addMaterial("Material 2", false);
        lesson16.addMaterial("Material 3", false);

        // Add lesson to this subject.
        this.addLesson(lesson16);
    }
}
