package homeschooltracker;

import junit.framework.TestCase;

public class MaterialTest extends TestCase {
    // Initialize test data
    String description1 = "Worksheet A";
    String description2 = "Phonics Book, Page 32";

    Material material1 = new Material(
        description1,
        true
    );

    Material material2 = new Material(
        description2,
        false
    );

    public void testGetDescription() {
        assertEquals(description1, material1.getDescription());
        assertEquals(description2, material2.getDescription());
    }

    public void testIsGraded() {
        assertTrue(material1.isGraded());
        assertFalse(material2.isGraded());
    }

    public void testToString() {
        String expected1 = "  [X] " + description1;
        String expected2 = "  [ ] " + description2;
        assertEquals(expected1, material1.toString());
        assertEquals(expected2, material2.toString());
    }

    public void testSetGraded() {
        material1.setGraded(false);
        assertFalse(material1.isGraded());

        material2.setGraded(true);
        assertTrue(material2.isGraded());
    }
}