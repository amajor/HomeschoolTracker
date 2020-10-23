package homeschooltracker.gui;

import homeschooltracker.content.Task;
import homeschooltracker.users.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentPanel extends JPanel {
    public StudentPanel(Student student) {
        // Build the Panel
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setLayout(new GridLayout(0, 1));
        // this.setLayout(new FlowLayout(4, 4, 4));

        // Add label
        this.add(new JLabel("Student Panel: " + student.getName()));

        // Get tasks for student
        ArrayList<Task> tasks = student.getTaskArrayList();
        addButtons(tasks);
    }

    public void addButtons(ArrayList<Task> tasks) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            // Add Button for each task
            JButtonStudentToCompleteTask specialButton = new JButtonStudentToCompleteTask(task.getName(), task);
            this.add(specialButton);
            specialButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JButtonStudentToCompleteTask tmpButton = (JButtonStudentToCompleteTask) event.getSource();
                    tmpButton.execute();
                }
            });
        }
    }
}
