package homeschooltracker.content;

import junit.framework.TestCase;

public class SubjectTest extends TestCase {
    // Initialize test data
    String subjectName = "MySubject";
    Subject subject = new Subject(subjectName);

    public void testGetName() {
        assertEquals(subjectName, subject.getName());
    }

    public void testAddLesson() {
        String name1 = "MyLesson1";
        String description1 = "This is lesson 1.";
        String name2 = "MyLesson2";
        String description2 = "This is lesson 2.";
        subject.addLesson(name1, description1, false);
        subject.addLesson(name2, description2, false);

        assertEquals(name1, subject.getLessonAtPosition(0).getName());
        assertEquals(description1, subject.getLessonAtPosition(0).getDescription());
        assertEquals(name2, subject.getLessonAtPosition(1).getName());
        assertEquals(description2, subject.getLessonAtPosition(1).getDescription());
    }
}