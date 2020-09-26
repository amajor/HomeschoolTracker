package homeschooltracker;

import junit.framework.TestCase;

public class SubjectTest extends TestCase {
    // Initialize test data
    String subjectName = "MySubject";
    Subject subject = new Subject(subjectName);

    public void testGetName() {
        assertEquals(subjectName, subject.getName());
    }
}