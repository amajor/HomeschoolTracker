package homeschooltracker.content;

import junit.framework.TestCase;

public class LessonTest extends TestCase {
    // Initialize test data
    String lessonName = "MyLesson";
    String lessonDescription = "This is a description of MyLesson";

    Lesson lesson = new Lesson(
            lessonName,
            lessonDescription,
            false,
            false,
            false
    );

    public void testGetName() {
        assertEquals(lessonName, lesson.getName());
    }

    public void testGetDescription() {
        assertEquals(lessonDescription, lesson.getDescription());
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
        String expectedString = "  [ ][ ][ ] " + lessonName + " - " + lessonDescription;
        assertEquals(expectedString, lesson.toString());
    }

    public void testAddMaterial() {
        String description1 = "Phonics Workbook Page 3";
        String description2 = "Reading Handbook Page 36";
        lesson.addMaterial(description1, false);
        lesson.addMaterial(description2, false);

        assertEquals(description1, lesson.getMaterialAtPosition(0).getDescription());
        assertEquals(description2, lesson.getMaterialAtPosition(1).getDescription());
    }
}