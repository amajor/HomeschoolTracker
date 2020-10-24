package homeschooltracker.content.taskState;

import homeschooltracker.content.Material;
import homeschooltracker.content.Task;
import junit.framework.TestCase;

public class IsPreparedStateTest extends TestCase {
    Task task = new Material("Fake Worksheet");
    State state = new IsPreparedState(task);

    public void testGetState() {
        assertEquals("isPrepared", state.getState());
    }

    public void testGetStateDescription() {
        String expected = "The task \"Fake Worksheet\" has been prepared.";
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
        assertFalse(state.isCompleted());
    }

    public void testIsGraded() {
        assertFalse(state.isGraded());
    }
}