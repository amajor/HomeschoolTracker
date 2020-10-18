package homeschooltracker.content;

import junit.framework.TestCase;

public class LessonTest extends TestCase {
    // Initialize test data
    String lessonName = "MyLesson";

    Lesson lesson = new Lesson(lessonName);

    public void testGetName() {
        assertEquals("LESSON: " + lessonName, lesson.getName());
    }

    public void testIsPrepared() {
        assertFalse(lesson.isPrepared());
    }

    public void testIsCompleted() {
        assertFalse(lesson.isCompleted());
    }

    public void testIsGraded() {
        assertFalse(lesson.isGraded());
    }

    public void testMarkPrepared() {
        // Confirm we're started with what we think
        assertFalse(lesson.isPrepared());
        assertFalse(lesson.isCompleted());
        assertFalse(lesson.isGraded());

        // Run the method
        lesson.setPrepared();

        // Test that it worked
        assertTrue(lesson.isPrepared());
        assertFalse(lesson.isCompleted());
        assertFalse(lesson.isGraded());
    }

    public void testMarkCompleted() {
        // Confirm we're started with what we think
        assertFalse(lesson.isPrepared());
        assertFalse(lesson.isCompleted());
        assertFalse(lesson.isGraded());

        // Run the method
        lesson.setCompleted();

        // Test that it worked
        assertTrue(lesson.isPrepared());
        assertTrue(lesson.isCompleted());
        assertFalse(lesson.isGraded());
    }

    public void testMarkGraded() {
        // Confirm we're started with what we think
        assertFalse(lesson.isPrepared());
        assertFalse(lesson.isCompleted());
        assertFalse(lesson.isGraded());

        // Run the method
        lesson.setGraded();

        // Test that it worked
        assertTrue(lesson.isPrepared());
        assertTrue(lesson.isCompleted());
        assertTrue(lesson.isGraded());
    }

    public void testToString() {
        String expectedString = "  [ ][ ][ ] LESSON: " + lessonName;
        assertEquals(expectedString, lesson.toString());
    }

    public void testAdd() {
        String description1 = "Phonics Workbook Page 3";
        String description2 = "Reading Handbook Page 36";
        Material task1 = new Material(description1);
        Material task2 = new Material(description2);
        lesson.add(task1);
        lesson.add(task2);

        assertEquals("-- " + description1, lesson.getChild(0).getName());
        assertEquals("-- " + description2, lesson.getChild(1).getName());
    }
}