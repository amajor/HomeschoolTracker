package homeschooltracker.gui;

import homeschooltracker.content.Task;

import javax.swing.*;
import java.awt.*;

public class JButtonStudentToCompleteTask extends JButton {
    Task task;

    public JButtonStudentToCompleteTask(String label, Task task) {
        super(label);
        this.task = task;
    }

    public void execute() {
        System.out.println("\nexecute JButtonStudentToCompleteTask: " + task.getName());
        task.setCompleted();
        System.out.println("  --> " + task.getStateDescription());

        // Remove the button once completed!
        Container parent = this.getParent();
        parent.remove(this);
        parent.revalidate();
        parent.repaint();
    }
}
