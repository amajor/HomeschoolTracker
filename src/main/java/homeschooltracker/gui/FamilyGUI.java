package homeschooltracker.gui;

import homeschooltracker.users.Parent;
import homeschooltracker.users.Student;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Iterator;

public class FamilyGUI {

    private JFrame frame;

    public FamilyGUI(Parent parent) {
        frame = new JFrame();
        frame.setTitle("Family Tasks");
        frame.setSize(700,1000);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 6));

        // Parent Panel
        JPanel parentPanel = new ParentPanel(parent);
        int numberOfStudents = parent.getNumberOfChildren();

        // Grid Panel
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(1, numberOfStudents + 1, 5, 5));
        gridPanel.add(parentPanel);

        // Build Student Panels
        Iterator<Student> studentsIterator = parent.getChildren().iterator();
        while (studentsIterator.hasNext()) {
            Student student = studentsIterator.next();
            // Student Panel
            JPanel studentPanel = new StudentPanel(student);
            gridPanel.add(studentPanel);
        }

        // Add the grid to main layout
        mainContainer.add(gridPanel, BorderLayout.CENTER);

        // Set it visible
        frame.setVisible(true);
    }
}
