package homeschooltracker.gui;

import homeschooltracker.users.Student;

import javax.swing.*;
import java.awt.*;

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

        // Add the panel to the frame and finish setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Tasks for " + student.getName());
        frame.pack();
        frame.setVisible(true);
    }
}
