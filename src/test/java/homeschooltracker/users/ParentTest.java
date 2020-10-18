package homeschooltracker.users;

import junit.framework.TestCase;

public class ParentTest extends TestCase {
    // Initialize test data
    String parentName = "Anya";

    Parent parent = new Parent(parentName);

    public void testGetName() {
        assertEquals(parentName, parent.getName());
    }

    public void testAddStudent() {
        Student student = new Student("Gwendolyn");
        parent.add(student);

        assertEquals("Gwendolyn", parent.getChild(0).getName());
    }

    public void testGetStudentAtPosition() {
        Student student1 = new Student("Gwendolyn");
        Student student2 = new Student("Eustace");
        parent.add(student1);
        parent.add(student2);

        assertEquals("Eustace", parent.getChild(1).getName());
    }
}