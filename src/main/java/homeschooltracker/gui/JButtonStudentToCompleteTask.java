/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.gui;

import homeschooltracker.content.Task;

import javax.swing.*;
import java.awt.*;

/**
 * This class builds a special button by extending {@code JButton}.
 * When clicked, this button will set a {@code Task} to the state {@code IsCompleted}.
 * @see homeschooltracker.content.taskState.IsCompletedState
 * @see homeschooltracker.content.Task
 * @author Alison Major
 */
public class JButtonStudentToCompleteTask extends JButton {
    Task task;

    /**
     * The constructor for building the button with a {@code Task} attached.
     * @see homeschooltracker.content.Task
     * @param label The label for the button (recommended: Task Name)
     * @param task The instance of the {@code Task}
     */
    public JButtonStudentToCompleteTask(String label, Task task) {
        super(label);
        this.task = task;
    }

    /**
     * Executes when the button is clicked. Sets the attached {@code Task} to the {@code IsCompleted} state.
     * Removes the button from the GUI once clicked.
     * @see homeschooltracker.content.taskState.IsCompletedState
     * @see homeschooltracker.content.Task
     */
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
