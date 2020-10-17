package homeschooltracker.content;

import junit.framework.TestCase;

public class MaterialTest extends TestCase {
    // Initialize test data
    String description1 = "Worksheet A";
    String description2 = "Phonics Book, Page 32";

    Material material1 = new Material(description1);
    Material material2 = new Material(description2);

    public void testGetDescription() {
        assertEquals(description1, material1.getDescription());
        assertEquals(description2, material2.getDescription());
    }

    public void testPrepared() {
        material1.setPrepared();
        assertTrue(material1.isPrepared());
        assertFalse(material2.isPrepared());
    }

    public void testCompleted() {
        material1.setCompleted();
        assertTrue(material1.isCompleted());
        assertFalse(material2.isCompleted());
    }

    public void testGraded() {
        material1.setGraded();
        assertTrue(material1.isGraded());
        assertFalse(material2.isGraded());
    }

    public void testToString() {
        material1.setGraded();
        String expected1 = "  [X][X][X] " + description1;

        material2.setPrepared();
        String expected2 = "  [X][ ][ ] " + description2;

        assertEquals(expected1, material1.toString());
        assertEquals(expected2, material2.toString());
    }

    public void testSetGraded() {
        assertFalse(material1.isGraded());

        material2.setGraded();
        assertTrue(material2.isGraded());
    }
}