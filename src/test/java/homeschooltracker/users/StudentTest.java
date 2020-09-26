package homeschooltracker.users;

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

        assertEquals("Reading 2, Grade 1", subject.getName());
    }
}