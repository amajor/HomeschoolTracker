package homeschooltracker.gui;

import homeschooltracker.content.Task;
import homeschooltracker.users.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentTaskGUI {

    private JFrame frame;
    private JPanel panel;

    public StudentTaskGUI(Student student) {
        frame = new JFrame();

        // Build the Panel
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));

        // Get tasks for student
        ArrayList<Task> tasks = student.getTaskArrayList();
        addButtons(tasks);

        // Add the panel to the frame and finish setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Tasks for " + student.getName());
        frame.pack();
        frame.setVisible(true);
    }

    public void addButtons(ArrayList<Task> tasks) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            // Add Button for each task
            JButtonStudentToCompleteTask specialButton = new JButtonStudentToCompleteTask(task.getName(), task);
            panel.add(specialButton);
            specialButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JButtonStudentToCompleteTask tmpButton = (JButtonStudentToCompleteTask) event.getSource();
                    tmpButton.execute();
                }
            });
        }
    }
}
