package homeschooltracker.gui;

import homeschooltracker.content.Task;

import javax.swing.*;
import java.awt.*;

public class JButtonParentToGradeTask extends JButton {
    Task task;

    public JButtonParentToGradeTask(String label, Task task) {
        super(label);
        this.task = task;
    }

    public void execute() {
        System.out.println("execute JButtonParentToGradeTask: " + task.getName());
        task.setGraded();
        System.out.println("  --> " + task.getStateDescription());

        // Remove the button once completed!
        Container parent = this.getParent();
        parent.remove(this);
        parent.revalidate();
        parent.repaint();
    }
}
