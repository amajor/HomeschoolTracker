package homeschooltracker.content.taskState;

import homeschooltracker.content.Material;
import homeschooltracker.content.Task;
import junit.framework.TestCase;

public class CurrentToPrepareStateTest extends TestCase {
    Task task = new Material("Fake Worksheet");
    State state = new CurrentToPrepareState(task);

    public void testGetState() {
        assertEquals("currentToPrepare", state.getState());
    }

    public void testGetStateDescription() {
        String expected = "This task \"Fake Worksheet\" is being prepared by the parent.";
        assertEquals(expected, state.getStateDescription());
    }

    public void testShowInParentList() {
        assertTrue(state.showInParentList());
    }

    public void testShowInStudentList() {
        assertFalse(state.showInStudentList());
    }

    public void testIsPrepared() {
        assertFalse(state.isPrepared());
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