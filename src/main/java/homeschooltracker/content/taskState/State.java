package homeschooltracker.content.taskState;

public interface State {
    public String getStateDescription();
    public String getState();
    public boolean showInParentList();
    public boolean showInStudentList();
    public boolean isPrepared();
    public boolean isCurrent();
    public boolean isCompleted();
    public boolean isGraded();
}
