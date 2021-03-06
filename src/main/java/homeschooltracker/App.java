/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker;

import homeschooltracker.content.Subject;
import homeschooltracker.content.SubjectFactory;
import homeschooltracker.content.Task;
import homeschooltracker.gui.FamilyGUI;
import homeschooltracker.users.Parent;
import homeschooltracker.users.Student;

/**
 * This is a class for running the homeschool tracker application.
 * @author Alison Major
 */
public class App {

    /**
     * The main method is where the GUI is generated and pre-loaded with some data in the Parent and Student instances.
     * @param args The arguments for the main method.
     */
    public static void main(String[] args) {
        // Build parent
        Parent parent = new Parent("Anya");
        initializeData(parent);

        // Build GUI
        new FamilyGUI(parent);
    }

    /**
     * This is a static method that initializes data for a parent by adding students. To the students, we add subjects
     * with lessons and materials.
     * @param parent
     */
    private static void initializeData(Parent parent) {
        // Build students
        Student student = new Student("Eustace");
        Student student2 = new Student("Gwendolyn");

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
        parent.add(student2);

        // Add Subject to Student
        student.add(subject0);
        student.add(subject1);
        student.add(subject2);
        student.add(subject3);
        student.add(subject4);
        student.add(subject5);

        student2.add(subject6);
        student2.add(subject7);
        student2.add(subject8);
        student2.add(subject9);

        // Grade a Lesson
        Task lesson1 = student.getChild(0).getChild(0);
        System.out.println("Set student 1 lesson as GRADED. " + lesson1.getName());
        lesson1.setGraded();

        // Complete a Lesson
        Task lesson2 = student.getChild(1).getChild(0);
        System.out.println("Set student 1 lesson as COMPLETED. " + lesson2.getName());
        lesson2.setCompleted();

        // Prepare a Lesson
        Task lesson3 = student.getChild(2).getChild(0);
        System.out.println("Set student 1 lesson as PREPARED. " + lesson3.getName());
        lesson3.setPrepared();

        // Prepare a Lesson
        Task lesson4 = student2.getChild(0).getChild(0);
        System.out.println("Set student 2 lesson as PREPARED. " + lesson4.getName());
        lesson4.setPrepared();

        // ***** Print Information *****

        // Print Parent
        parent.print();

        // Print Child
        Student myStudent = parent.getChild(0);
        myStudent.print();

        // Print Child
        Student myStudent2 = parent.getChild(1);
        myStudent2.print();

        // Print Task Lists
        parent.printTasks();
        System.out.println("\n");
        student.printTasks();
        student2.printTasks();
    }
}
