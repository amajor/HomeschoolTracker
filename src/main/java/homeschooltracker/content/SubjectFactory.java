/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.content;

import homeschooltracker.content.subjects.grade1.*;

/**
 * A factory for creating different subjects loaded with {@code Lesson}s.
 * @author Alison Major
 */
public class SubjectFactory {
    /**
     * Gets the {@code Subject} based on the type passed in.
     * @param type A string designation for the Subject desired.
     * @return The concrete {@code Subject}
     */
    public Subject getSubject(String type) {
        if (type.equals("BIBLE1")) {
            return new Bible();
        } else if (type.equals("SEATWORK1")) {
            return new Seatwork();
        } else if (type.equals("READING1_AML2")) {
            return new ReadingAmLevel2();
        } else if (type.equals("PHONICS1")) {
            return new PhonicsLanguage();
        } else if (type.equals("WRITING1")) {
            return new Writing();
        } else if (type.equals("ARITHMETIC1")) {
            return new Arithmetic();
        } else if (type.equals("READING1_PML2")) {
            return new ReadingPmLevel2();
        } else if (type.equals("SPELLING1")) {
            return new SpellingPoetry();
        } else if (type.equals("COMBINATION1")) {
            return new Combination();
        } else if (type.equals("ACTIVITY1")) {
            return new ActivityTime();
        } else if (type.equals("BIBLE2")) {
            return new homeschooltracker.content.subjects.grade2.Bible();
        }
        return null;
    }
}
