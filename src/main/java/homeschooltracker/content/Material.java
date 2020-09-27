package homeschooltracker.content;

public class Material {
    String description;
    Boolean graded;

    public Material(
            String description,
            boolean graded)
    {
        this.description = description;
        this.graded = graded;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isGraded() {
        return graded;
    }

    public void setGraded(Boolean graded) {
        this.graded = graded;
    }

    @Override
    public String toString() {
        String check = " ";
        if (graded) {
            check = "X";
        }
        return ("  [" + check + "] " + description);
    }
}
