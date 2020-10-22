package homeschooltracker;

import homeschooltracker.content.Task;

import javax.swing.*;

public class JButtonParentTask extends JButton {
    Task task;

    public JButtonParentTask(String label, Task task) {
        super(label);
        this.task = task;
    }

    public void execute() {
        task.setPrepared();
    }
}
