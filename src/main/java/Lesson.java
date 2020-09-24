public class Lesson {
    String name;
    String description;
    boolean completed;

    public Lesson(
            String name,
            String description,
            boolean completed)
    {
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isUnfinished() {
        return !completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public String toString() {
        String check = " ";
        if (completed) {
            check = "X";
        }
        return ("\n\n  [" + check + "] " + name + "\n      " + description);
    }
}