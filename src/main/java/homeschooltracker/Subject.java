package homeschooltracker;

public class Subject {
    String name;

    public Subject(
            String name
    )
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printSubjectName() {
        System.out.println("\nSubject: " + getName());
    }
}
