package homeschooltracker.content.taskState;

import homeschooltracker.content.Material;
import homeschooltracker.content.Task;
import junit.framework.TestCase;

public class IsCompletedStateTest extends TestCase {
    Task task = new Material("Fake Worksheet");
    State state = new IsCompletedState(task);

    public void testGetState() {
        assertEquals("isCompleted", state.getState());
    }

    public void testGetStateDescription() {
        String expected = "The task \"Fake Worksheet\" has been completed by the student.";
        assertEquals(expected, state.getStateDescription());
    }

    public void testShowInParentList() {
        assertTrue(state.showInParentList());
    }

    public void testShowInStudentList() {
        assertFalse(state.showInStudentList());
    }

    public void testIsPrepared() {
        assertTrue(state.isPrepared());
    }

    public void testIsCurrent() {
        assertFalse(state.isCurrent());
    }

    public void testIsCompleted() {
        assertTrue(state.isCompleted());
    }

    public void testIsGraded() {
        assertFalse(state.isGraded());
    }
}