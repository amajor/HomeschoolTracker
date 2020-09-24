import junit.framework.TestCase;

public class LessonTest extends TestCase {
    // Initialize test data
    String lessonName = "MyLesson";
    String lessonDescription = "This is a description of MyLesson";
    boolean lessonCompleted = false;

    Lesson lesson = new Lesson(
            lessonName,
            lessonDescription,
            false
    );

    public void testTestGetName() {
        assertEquals(lessonName, lesson.getName());
    }

    public void testGetDescription() {
        assertEquals(lessonDescription, lesson.getDescription());
    }

    public void testIsCompleted() {
        assertFalse(lesson.isCompleted());
    }

    public void testIsUnfinished() {
        assertTrue(lesson.isUnfinished());
    }

    public void testMarkCompleted() {
        // Confirm we're started with what we think
        assertFalse(lesson.isCompleted());
        assertTrue(lesson.isUnfinished());

        // Run the method
        lesson.markCompleted();

        // Test that it worked
        assertTrue(lesson.isCompleted());
        assertFalse(lesson.isUnfinished());
    }

    public void testTestToString() {
        String expectedString = "\n\n  [ ] " + lessonName + "\n      " + lessonDescription;
        assertEquals(expectedString, lesson.toString());
    }
}