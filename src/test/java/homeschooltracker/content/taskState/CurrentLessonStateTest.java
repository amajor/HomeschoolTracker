package homeschooltracker.content.taskState;

import homeschooltracker.content.Material;
import homeschooltracker.content.Task;
import junit.framework.TestCase;

public class CurrentLessonStateTest extends TestCase {
    Task task = new Material("Fake Worksheet");
    State state = new CurrentLessonState(task);

    public void testGetState() {
        assertEquals("currentLesson", state.getState());
    }

    public void testGetStateDescription() {
        String expected = "This task \"Fake Worksheet\" is in progress by the student.";
        assertEquals(expected, state.getStateDescription());
    }

    public void testShowInParentList() {
        assertFalse(state.showInParentList());
    }

    public void testShowInStudentList() {
        assertTrue(state.showInStudentList());
    }

    public void testIsPrepared() {
        assertTrue(state.isPrepared());
    }

    public void testIsCurrent() {
        assertTrue(state.isCurrent());
    }

    public void testIsCompleted() {
        assertFalse(state.isCompleted());
    }

    public void testIsGraded() {
        assertFalse(state.isGraded());
    }
}