/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.gui;

import homeschooltracker.users.Parent;
import homeschooltracker.users.Student;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * The {@code FamilyGUI} class builds a graphical user interface for interacting with the Homeschool Tracker methods
 * and data.
 * @author Alison Major
 */
public class FamilyGUI {

    private JFrame frame;
    private Parent parent;
    private Container mainContainer;

    /**
     * Builds the graphical user interface based on the parent and the data contained under the parent.
     * @param parent The parent that is assisting the students
     */
    public FamilyGUI(Parent parent) {
        this.parent = parent;

        // Build the frame
        frame = new JFrame();
        frame.setTitle("Family Tasks");
        frame.setSize(1500,1000);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Draw the interior panels
        drawPanels();

        // Set it visible
        frame.setVisible(true);
    }

    /**
     * Draws panels for the {@code FamilyGUI} class. This method is extracted so that we can redraw as tasks are
     * updated.
     */
    public void drawPanels() {
        mainContainer = frame.getContentPane();
        mainContainer.removeAll(); // Clear everything out for redraws on updates
        mainContainer.setLayout(new BorderLayout(8, 6));

        // Parent Panel
        JPanel parentPanel = new ParentPanel(parent, this);
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
            JPanel studentPanel = new StudentPanel(student, this);
            gridPanel.add(studentPanel);
        }

        // Add the grid to main layout
        mainContainer.add(gridPanel, BorderLayout.CENTER);
    }
}
