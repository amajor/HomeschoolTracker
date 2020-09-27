package homeschooltracker;

import homeschooltracker.content.Lesson;
import homeschooltracker.content.Subject;
import homeschooltracker.content.SubjectFactory;
import homeschooltracker.users.Parent;
import homeschooltracker.users.Student;

public class App {
    public static void main(String[] args) {
        Parent parent = new Parent("Anya");
        Student student = new Student("Eustace");

        // Create the subjects using the Factory
        SubjectFactory subjectFactory = new SubjectFactory();
        Subject subject = subjectFactory.getSubject("READING1A");

        // Add Student to Parent
        parent.addStudent(student);
        parent.printName();

        // Add Subject to Student
        student.addSubject(subject);
        student.printName();
        Subject studentSubject = student.getSubjectAtPosition(0);
        studentSubject.printSubjectName();
        studentSubject.printLessonList();

        System.out.print("\n---------------------\n");
        Lesson studentLesson = studentSubject.getLessonAtPosition(0);
        System.out.println(studentLesson.getName());
        studentLesson.printMaterialList();

        System.out.print("\n======================\n");

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
