package homeschooltracker.content;

import java.util.ArrayList;
import java.util.Iterator;

abstract public class Subject {
    public String name;
    ArrayList<Lesson> lessonArrayList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void addLesson(String name, String description, boolean prepared, boolean completed, boolean graded) {
        Lesson lesson = new Lesson(name, description);
        lessonArrayList.add(lesson);
    }

    public void addLesson(Lesson lesson) {
        lessonArrayList.add(lesson);
    }

    public Lesson getLessonAtPosition(int position) {
        return lessonArrayList.get(position);
    }

    public void printSubjectName() {
        System.out.println("\nSubject: " + getName());
    }

    public void printLessonList() {
        // Create an iterator for the list using iterator() method
        Iterator<Lesson> iterator = lessonArrayList.iterator();

        // Displaying the values after iterating through the list
        while (iterator.hasNext()) {
            System.out.println("    " + iterator.next());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
