package homeschooltracker.users;

import homeschooltracker.content.subjects.grade1.ReadingAmLevel2;
import homeschooltracker.content.subjects.grade1.Seatwork;
import junit.framework.TestCase;

public class StudentTest extends TestCase {
    // Initialize test data
    String studentName = "Eustace";

    Student student = new Student(studentName);

    public void testGetName() {
        assertEquals(studentName, student.getName());
    }

    public void testAddSubject() {
        ReadingAmLevel2 subject = new ReadingAmLevel2();
        student.addSubject(subject);

        assertEquals("Reading AM 2, Grade 1", student.getSubjectAtPosition(0).getName());
    }

    public void testGetSubjectAtPosition() {
        ReadingAmLevel2 subject1 = new ReadingAmLevel2();
        student.addSubject(subject1);
        Seatwork subject2 = new Seatwork();
        student.addSubject(subject2);

        assertEquals("Seatwork, Grade 1", student.getSubjectAtPosition(1).getName());
    }
}