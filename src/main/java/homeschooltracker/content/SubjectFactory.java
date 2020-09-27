package homeschooltracker.content;

import homeschooltracker.content.subjects.SubjectGrade1Reading2;

public class SubjectFactory {
    public Subject getSubject(String type) {
        if (type.equals("READING1A")) {
            return new SubjectGrade1Reading2();
        } else if (type.equals("PHONICS1")) {
            return new SubjectGrade1Reading2();
        }
        return null;
    }
}
