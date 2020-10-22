package homeschooltracker;

import homeschooltracker.content.Task;

import javax.swing.*;
import java.awt.*;

public class JButtonParentTask extends JButton {
    Task task;

    public JButtonParentTask(String label, Task task) {
        super(label);
        this.task = task;
    }

    public void execute() {
        System.out.println("execute JButtonParentTask: " + task.getName());
        task.setPrepared();
        System.out.println("  --> " + task.getStateDescription());

        // Remove the button once completed!
        Container parent = this.getParent();
        parent.remove(this);
        parent.revalidate();
        parent.repaint();
    }
}
