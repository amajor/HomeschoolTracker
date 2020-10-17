package homeschooltracker.content.lessonState;

public interface State {
    String status = null;

    public String getStateDescription();
    public boolean showInParentList();
    public boolean showInStudentList();
}
