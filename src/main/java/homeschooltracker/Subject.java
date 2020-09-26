package homeschooltracker;

import java.util.ArrayList;

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

    public Lesson getLessonAtPosition(int position) {
        return lessonArrayList.get(position);
    }

    public void printSubjectName() {
        System.out.println("\nSubject: " + getName());
    }
}
