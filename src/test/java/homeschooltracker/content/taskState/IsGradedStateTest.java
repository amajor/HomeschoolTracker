package homeschooltracker.content.taskState;

import homeschooltracker.content.Material;
import homeschooltracker.content.Task;
import junit.framework.TestCase;

public class IsGradedStateTest extends TestCase {
    Task task = new Material("Fake Worksheet");
    State state = new IsGradedState(task);

    public void testGetState() {
        assertEquals("isGraded", state.getState());
    }

    public void testGetStateDescription() {
        String expected = "The task \"Fake Worksheet\" has been graded.";
        assertEquals(expected, state.getStateDescription());
    }

    public void testShowInParentList() {
        assertFalse(state.showInParentList());
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
        assertTrue(state.isGraded());
    }
}