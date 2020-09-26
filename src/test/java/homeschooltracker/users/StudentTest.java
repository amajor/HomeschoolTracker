package homeschooltracker.users;

import homeschooltracker.content.Lesson;
import junit.framework.TestCase;

public class StudentTest extends TestCase {
    // Initialize test data
    String studentName = "Eustace";

    Student student = new Student(studentName);

    public void testGetName() {
        assertEquals(studentName, student.getName());
    }
}