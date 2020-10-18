package homeschooltracker;

import homeschooltracker.content.Subject;
import homeschooltracker.content.SubjectFactory;
import homeschooltracker.content.Task;
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
        parent.add(student);

        // Add Subject to Student
        student.add(subject0);
        student.add(subject1);
        student.add(subject2);
        student.add(subject3);
        student.add(subject4);
        student.add(subject5);
        student.add(subject6);
        student.add(subject7);
        student.add(subject8);
        student.add(subject9);

        // Grade a Lesson
        Task bibleLesson = student.getChild(0).getChild(0);
        System.out.println("Set Bible lesson as GRADED. " + bibleLesson.getName());
        bibleLesson.setGraded();

        // Complete a Lesson
        Task mathLesson = student.getChild(5).getChild(0);
        System.out.println("Set seatwork lesson as COMPLETED. " + mathLesson.getName());
        mathLesson.setCompleted();

        // Prepare a Lesson
        Task readingLesson = student.getChild(2).getChild(0);
        System.out.println("Set reading lesson as PREPARED. " + readingLesson.getName());
        readingLesson.setPrepared();

        // Prepare a Lesson
        Task phonicsLesson = student.getChild(3).getChild(0);
        System.out.println("Set phonics lesson as PREPARED. " + phonicsLesson.getName());
        phonicsLesson.setPrepared();

        // Prepare parts of a Lesson
        Task seatworkLesson = student.getChild(1).getChild(0);
        System.out.println("Set some seatwork materials as PREPARED. " + seatworkLesson.getName());
        seatworkLesson.setReadyToPrepare();
        System.out.println("... Seatwork State: " + seatworkLesson.getStateDescription());
        seatworkLesson.setChildPrepared(0);
        System.out.println("... Seatwork Task 0 State: " + seatworkLesson.getChild(0).getStateDescription());
        seatworkLesson.setChildPrepared(2);
        System.out.println("... Seatwork Task 2 State: " + seatworkLesson.getChild(2).getStateDescription());

        // Prepare ALL parts of a Lesson
        Task writingLesson = student.getChild(4).getChild(0);
        writingLesson.setReadyToPrepare();
        System.out.println("Set some writing materials as PREPARED. " + writingLesson.getName());
        writingLesson.setChildPrepared(0);
        writingLesson.setChildPrepared(1);
        System.out.println("... Writing State: " + writingLesson.getStateDescription());

        // ***** Print Information *****

        // Print Parent
        parent.print();

        // Print Child
        Student myStudent = parent.getChild(0);
        myStudent.print();

        // Print Task Lists
        parent.printTasks();
        System.out.println("\n");
        student.printTasks();

        // Print Subjects in various states
//        subject0.print();
//        subject1.print();
//        subject2.print();
//        subject3.print();
    }
}
