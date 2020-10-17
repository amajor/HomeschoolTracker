package homeschooltracker.users;

import homeschooltracker.content.Subject;
import homeschooltracker.content.Task;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
    String name;
    ArrayList<Subject> subjectArrayList = new ArrayList<>();

    public Student(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        subjectArrayList.add(subject);
    }

    public Subject getSubjectAtPosition(int position) {
        return subjectArrayList.get(position);
    }

    public void printName() {
        System.out.println("\nStudent: " + getName());
    }

    public void printSubjectList() {
        // Create an iterator for the list using iterator() method
        Iterator<Subject> iterator = subjectArrayList.iterator();

        // Displaying the values after iterating through the list
        System.out.println("  Subjects: ");
        while (iterator.hasNext()) {
            System.out.println("    " + iterator.next());
        }
    }

    public void printSubjectListWithLessons() {
        // Create an iterator for the list using iterator() method
        Iterator<Subject> iterator = subjectArrayList.iterator();

        // Displaying the values after iterating through the list
        if (iterator.hasNext()) {
            System.out.println("  Subjects with Lessons:");
        }
        while (iterator.hasNext()) {
            Subject current = iterator.next();
            System.out.println("    " + current);
            current.print();
        }
    }

    public void printSubjectListWithLessonsAtPosition(int position, boolean showMaterials) {
        // Create an iterator for the list using iterator() method
        Iterator<Subject> iterator = subjectArrayList.iterator();

        // Displaying the values after iterating through the list
        if (iterator.hasNext()) {
            System.out.println("  Subjects with Lesson at position " + position + ":");
        }
        while (iterator.hasNext()) {
            Subject currentSubject = iterator.next();
            System.out.println("    SUBJECT: " + currentSubject);
            try {
                Task lesson = currentSubject.getChild(position);
                System.out.println("    LESSON:" + lesson);
                if(showMaterials) {
                    System.out.println("\n=== LESSON: " + lesson.getName() + " ===");
                    System.out.println("    LESSON STATE:" + lesson.getStateDescription());
                    System.out.println("    LESSON MATERIALS:");
                    currentSubject.getChild(position).print();
                }
            } catch(Exception e) {
                System.out.println("      No lesson at position " + position + " for this subject.");
            }
        }
    }
}
