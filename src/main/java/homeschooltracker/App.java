package homeschooltracker;

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
        Subject subject0 = subjectFactory.getSubject("BIBLE1");
        Subject subject1 = subjectFactory.getSubject("SEATWORK1");
        Subject subject2 = subjectFactory.getSubject("READING1_AML2");
        Subject subject3 = subjectFactory.getSubject("PHONICS1");
        Subject subject4 = subjectFactory.getSubject("WRITING1");
        Subject subject5 = subjectFactory.getSubject("ARITHMETIC1");
        Subject subject6 = subjectFactory.getSubject("READING1_PML2");
        Subject subject7 = subjectFactory.getSubject("SPELLING1");
        Subject subject8 = subjectFactory.getSubject("COMBINATION1");
        Subject subject9 = subjectFactory.getSubject("ACTIVITY1");

        // Add Student to Parent
        parent.addStudent(student);

        // Add Subject to Student
        student.addSubject(subject0);
        student.addSubject(subject1);
        student.addSubject(subject2);
        student.addSubject(subject3);
        student.addSubject(subject4);
        student.addSubject(subject5);
        student.addSubject(subject6);
        student.addSubject(subject7);
        student.addSubject(subject8);
        student.addSubject(subject9);

        // Grade a Lesson
        student.getSubjectAtPosition(0).getLessonAtPosition(0).setGraded();

        // Complete a Lesson
        student.getSubjectAtPosition(1).getLessonAtPosition(0).setCompleted();

        // Prepare a Lesson
        student.getSubjectAtPosition(2).getLessonAtPosition(0).setPrepared();

        // Print Information
        parent.printName();
        student.printName();
        student.printSubjectListWithLessonsAtPosition(0, true);
        student.printSubjectListWithLessonsAtPosition(1, false);
    }
}
