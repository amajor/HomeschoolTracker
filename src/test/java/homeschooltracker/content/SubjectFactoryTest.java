package homeschooltracker.content;

import junit.framework.TestCase;

public class SubjectFactoryTest extends TestCase {
    SubjectFactory subjectFactory = new SubjectFactory();

    public void testGetSubjectBible1() {
        String type = "BIBLE1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Bible, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectBible2() {
        String type = "BIBLE2";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Bible, Grade 2", factoryResult.getName());
    }

    public void testGetSubjectSeatwork1() {
        String type = "SEATWORK1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Seatwork, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectReading1() {
        String type = "READING1_AML2";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Reading AM 2, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectReading2() {
        String type = "READING1_PML2";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Reading PM 2, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectPhonics1() {
        String type = "PHONICS1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Phonics / Language, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectWriting1() {
        String type = "WRITING1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Writing, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectArithmetic1() {
        String type = "ARITHMETIC1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Arithmetic, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectSpelling1() {
        String type = "SPELLING1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Spelling & Poetry, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectCombination1() {
        String type = "COMBINATION1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Combination, Grade 1", factoryResult.getName());
    }

    public void testGetSubjectActivity1() {
        String type = "ACTIVITY1";
        Subject factoryResult = subjectFactory.getSubject(type);
        assertEquals("Activity Time, Grade 1", factoryResult.getName());
    }
}