package homeschooltracker.users;

import homeschooltracker.content.Subject;
import homeschooltracker.content.SubjectGrade1Reading2;
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
        parent.addStudent(student);

        assertEquals("Gwendolyn", parent.getStudentAtPosition(0).getName());
    }

    public void testGetStudentAtPosition() {
        Student student1 = new Student("Gwendolyn");
        Student student2 = new Student("Eustace");
        parent.addStudent(student1);
        parent.addStudent(student2);

        assertEquals("Eustace", parent.getStudentAtPosition(1).getName());
    }
}