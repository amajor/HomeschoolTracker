package homeschooltracker.content;

import java.util.ArrayList;
import java.util.Iterator;

public class Subject {
    String name;
    ArrayList<Lesson> lessonArrayList = new ArrayList<>();

    public Subject(
            String name
    )
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLesson(String name, String description, Boolean completed) {
        Lesson lesson = new Lesson(name, description, completed);
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
        System.out.println("  Lessons: ");
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
    }
}
