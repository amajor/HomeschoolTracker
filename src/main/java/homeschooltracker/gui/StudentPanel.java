/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.gui;

import homeschooltracker.content.Task;
import homeschooltracker.users.Student;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The {@code StudentPanel} class extends {@code JPanel} and builds a panel with {@code Student} tasks.
 * @author Alison Major
 */
public class StudentPanel extends JPanel {
    private FamilyGUI familyGUI;

    /**
     * The constructor builds the {@code JPanel} specifically for a {@code Student}. If a task is clicked, the
     * {@code FamilyGUI} is redrawn.
     * @see homeschooltracker.users.Student
     * @see homeschooltracker.content.Task
     * @param student The Student that has tasks to complete for a lesson.
     * @param familyGUI The GUI that contains the StudentPanel.
     */
    public StudentPanel(Student student, FamilyGUI familyGUI) {
        this.familyGUI = familyGUI;

        // Build the Panel
        Border bevelBorder = BorderFactory.createLoweredBevelBorder();
        Border spaceBorder = BorderFactory.createEmptyBorder(30, 30,30,30);
        this.setBorder(BorderFactory.createCompoundBorder(bevelBorder, spaceBorder));
        this.setLayout(new GridLayout(30, 1));
        // this.setLayout(new FlowLayout(4, 4, 4));

        // Add label
        JLabel title = new JLabel("Student Panel: " + student.getName());
        title.setFont(new Font("Helvetica", Font.BOLD, 24));
        this.add(title);

        // Add buttons of the tasks
        ArrayList<Task> tasks = getTasks(student, "currentLesson");
        addButtons(student.getName(), tasks);
    }

    /**
     * Gets the tasks belonging to a {@code Student} that matches a given {@code State}
     * @param student The Student that has tasks to complete for a lesson.
     * @param state The current state of the task.
     * @return An array list of {@code Task} items belong to the {@code Student} that match a certain state.
     */
    public ArrayList<Task> getTasks(Student student, String state) {
        // Get tasks for student
        ArrayList<Task> subjects = student.getTaskArrayList();
        ArrayList<Task> lessons = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Task> currentTasks = new ArrayList<>();

        // Get the current lessons from the subjects
        Iterator<Task> subjectIterator = subjects.iterator();
        while (subjectIterator.hasNext()) {
            Task subject = subjectIterator.next();
            lessons.addAll(subject.getTaskArrayList());
        }

        // Get the tasks from the current lessons
        Iterator<Task> lessonIterator = lessons.iterator();
        while (lessonIterator.hasNext()) {
            Task lesson = lessonIterator.next();
            tasks.addAll(lesson.getTaskArrayList());
        }

        // Get the current tasks from all tasks
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();
            if (task.getState() == state) {
                currentTasks.add(task);
            }
        }
        return currentTasks;
    }

    /**
     * Adds buttons for each {@code Task} in a provided array list. If the button is clicked, the task will be set
     * to the state, {@code IsCompletedState}.
     * @see homeschooltracker.gui.JButtonStudentToCompleteTask
     * @see homeschooltracker.content.taskState.IsCompletedState
     * @param tasks The tasks to create buttons for. Clicking the button will set the state to {@code IsCompletedState}.
     */
    public void addButtons(String studentName, ArrayList<Task> tasks) {
        if (tasks.size() > 0) {
            Iterator<Task> taskIterator = tasks.iterator();
            while (taskIterator.hasNext()) {
                Task task = taskIterator.next();
                // Add Button for each task
                JButtonStudentToCompleteTask specialButton = new JButtonStudentToCompleteTask(task.getName(), task);
                this.add(specialButton);
                specialButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        JButtonStudentToCompleteTask tmpButton = (JButtonStudentToCompleteTask) event.getSource();
                        tmpButton.execute();
                        familyGUI.drawPanels();
                    }
                });
            }
        } else {
            // Add label
            JLabel label = new JLabel("-- Great job,  " + studentName + "! Done for today! --");
            label.setFont(new Font("Helvetica", Font.PLAIN, 16));
            label.setForeground(Color.RED);
            this.add(label);
        }

    }
}
