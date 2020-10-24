package homeschooltracker.content;

import junit.framework.TestCase;

public class SubjectTest extends TestCase {
    SubjectFactory subjectFactory = new SubjectFactory();
    Subject subject = subjectFactory.getSubject("BIBLE1");

    public void testToString() {
        assertEquals("Bible, Grade 1", subject.toString());
    }
}
