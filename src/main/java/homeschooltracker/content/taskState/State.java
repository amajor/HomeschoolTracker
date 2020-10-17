package homeschooltracker.content.taskState;

public interface State {
    public String getStateDescription();
    public boolean showInParentList();
    public boolean showInStudentList();
    public boolean isPrepared();
    public boolean isCompleted();
    public boolean isGraded();
}
