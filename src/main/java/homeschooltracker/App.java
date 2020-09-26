package homeschooltracker;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.SubjectGrade1Reading2;

public class App {
    public static void main(String[] args) {
        SubjectGrade1Reading2 subject = new SubjectGrade1Reading2();

        // Build lesson 12
        Lesson lesson = new Lesson(
                "Lesson 12",
                "This is lesson 12 for phonics and reading.",
                false
        );
        subject.addLesson(lesson);
        lesson.addMaterial("Handbook for Reading, pages 20-25", false);
        lesson.addMaterial("Phonics workbook, page 30", false);

        // Build lesson 13
        subject.addLesson("Lesson 13", "This is lesson 13.", false);
        subject.getLessonAtPosition(1).addMaterial("Fun with Pets, pages 32-40", false);

        // Print from the subject
        subject.printSubjectName();
        subject.printLessonList();

        System.out.print("\n======================\n");

        // Print from the subject's lesson
        subject.getLessonAtPosition(0).printLessonName();
        subject.getLessonAtPosition(0).printMaterialList();

        System.out.print("\n======================\n");

        // Print from the lesson
        lesson.printLessonName();
        lesson.printMaterialList();

        System.out.print("\n======================\n");

        // Print from the subject's lesson
        subject.getLessonAtPosition(1).printLessonName();
        subject.getLessonAtPosition(1).printMaterialList();
    }
}
