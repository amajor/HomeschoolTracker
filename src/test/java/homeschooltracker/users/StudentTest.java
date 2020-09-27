package homeschooltracker.users;

import homeschooltracker.content.Subject;
import homeschooltracker.content.SubjectGrade1Reading2;
import junit.framework.TestCase;

public class StudentTest extends TestCase {
    // Initialize test data
    String studentName = "Eustace";

    Student student = new Student(studentName);

    public void testGetName() {
        assertEquals(studentName, student.getName());
    }

    public void testAddSubject() {
        SubjectGrade1Reading2 subject = new SubjectGrade1Reading2();
        student.addSubject(subject);

        assertEquals("Reading 2, Grade 1", student.getSubjectAtPosition(0).getName());
    }

    public void testGetSubjectAtPosition() {
        SubjectGrade1Reading2 subject1 = new SubjectGrade1Reading2();
        Subject subject2 = new Subject();
        student.addSubject(subject1);
        student.addSubject(subject2);

        assertEquals("Unnamed Subject", student.getSubjectAtPosition(1).getName());
    }
}