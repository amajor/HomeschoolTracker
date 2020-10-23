/*
 * (c) 2020 Alison Major. All rights reserved.
 */
package homeschooltracker.gui;

import homeschooltracker.content.Task;
import homeschooltracker.users.Parent;
import homeschooltracker.users.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The {@code ParentPanel} class extends {@code JPanel} and builds a panel with {@code Parent} tasks.
 * @author Alison Major
 */
public class ParentPanel extends JPanel {
    private FamilyGUI familyGUI;

    /**
     * The constructor builds the {@code JPanel} specifically for a {@code Parent}. If a task is clicked, the
     * {@code FamilyGUI} is redrawn.
     * @see homeschooltracker.users.Parent
     * @see homeschooltracker.users.Student
     * @see homeschooltracker.content.Task
     * @param parent The Parent that has tasks to complete for a lesson.
     * @param familyGUI The GUI that contains the StudentPanel.
     */
    public ParentPanel(Parent parent, FamilyGUI familyGUI) {
        this.familyGUI = familyGUI;

        // Build the Panel
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setLayout(new GridLayout(0, 1));

        // Add label
        this.add(new JLabel("Parent Panel: " + parent.getName()));
        this.add(new JLabel("Number of Students: " + parent.getNumberOfChildren()));

        // Get tasks for parent
        ArrayList<Student> students = parent.getChildren();

        // Iterate through children
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            // Add Child Labels
            Student student = studentIterator.next();

            // Add tasks to prepare
            ArrayList<Task> toPrepareTasks = getTasks(student, "currentToPrepare");
            addToPrepareButtons(toPrepareTasks, student.getName());

            // Add tasks to complete
            ArrayList<Task> toGradeTasks = getTasks(student, "isCompleted");
            addToGradeButtons(toGradeTasks, student.getName());
        }
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
     * to the state, {@code IsPreparedState}.
     * @see homeschooltracker.gui.JButtonParentToPrepareTask
     * @see homeschooltracker.content.taskState.IsPreparedState
     * @param tasks The tasks to create buttons for. Clicking the button will set the state to {@code IsPreparedState}.
     * @param studentName The name of the student who the tasks belong to.
     */
    public void addToPrepareButtons(ArrayList<Task> tasks, String studentName) {
        String prepareLabelText = "";
        if (tasks.size() > 0) {
            prepareLabelText = "Prepare for " + studentName;
        } else {
            prepareLabelText = "-- No lessons to prepare for " + studentName + " --";
        }
        JLabel childPrepareLabel = new JLabel(prepareLabelText);
        this.add(childPrepareLabel);

        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();
            // Add Button for each task
            JButtonParentToPrepareTask specialButton = new JButtonParentToPrepareTask(task.getName(), task);
            this.add(specialButton);
            specialButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JButtonParentToPrepareTask tmpButton = (JButtonParentToPrepareTask) event.getSource();
                    tmpButton.execute();
                    familyGUI.drawPanels();
                }
            });
        }
    }

    /**
     * Adds buttons for each {@code Task} in a provided array list. If the button is clicked, the task will be set
     * to the state, {@code IsGradedState}.
     * @see homeschooltracker.gui.JButtonParentToPrepareTask
     * @see homeschooltracker.content.taskState.IsGradedState
     * @param tasks The tasks to create buttons for. Clicking the button will set the state to {@code IsGradedState}.
     * @param studentName The name of the student who the tasks belong to.
     */
    public void addToGradeButtons(ArrayList<Task> tasks, String studentName) {
        String gradeLabelText = "";
        if (tasks.size() > 0) {
            gradeLabelText = "Grade for " + studentName;
        } else {
            gradeLabelText = "-- No lessons to grade for " + studentName + " --";
        }
        JLabel childGradeLabel = new JLabel(gradeLabelText);
        this.add(childGradeLabel);

        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();
            // Add Button for each task
            JButtonParentToGradeTask specialButton = new JButtonParentToGradeTask(task.getName(), task);
            this.add(specialButton);
            specialButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JButtonParentToGradeTask tmpButton = (JButtonParentToGradeTask) event.getSource();
                    tmpButton.execute();
                    familyGUI.drawPanels();
                }
            });
        }
    }
}
