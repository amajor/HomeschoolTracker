package homeschooltracker.users;

import homeschooltracker.content.subjects.SubjectGrade1Reading2;
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
        student.addSubject(subject1);
        // Add second subject
        student.addSubject(subject1);

        assertEquals("Reading 2, Grade 1", student.getSubjectAtPosition(1).getName());
    }
}