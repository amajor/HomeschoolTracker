package homeschooltracker.gui;

import homeschooltracker.content.Task;

import javax.swing.*;
import java.awt.*;

public class JButtonParentToPrepareTask extends JButton {
    Task task;

    public JButtonParentToPrepareTask(String label, Task task) {
        super(label);
        this.task = task;
    }

    public void execute() {
        System.out.println("execute JButtonParentToPrepareTask: " + task.getName());
        task.setPrepared();
        System.out.println("  --> " + task.getStateDescription());

        // Remove the button once completed!
        Container parent = this.getParent();
        parent.remove(this);
        parent.revalidate();
        parent.repaint();
    }
}
