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
        student.getChild(0).getChild(0).setGraded();

        // Complete a Lesson
        student.getChild(1).getChild(0).setCompleted();

        // Prepare a Lesson
        student.getChild(2).getChild(0).setPrepared();

        // ***** Print Information *****

        // Print Parent
        parent.print();

        // Print Child
        Student myStudent = parent.getChild(0);
        myStudent.print();

        // Print Child's Tasks
        myStudent.printTasks();
    }
}
