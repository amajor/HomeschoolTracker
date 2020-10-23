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
    private FamilyGUI familyGUI;

    public StudentPanel(Student student, FamilyGUI familyGUI) {
        this.familyGUI = familyGUI;

        // Build the Panel
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setLayout(new GridLayout(0, 1));
        // this.setLayout(new FlowLayout(4, 4, 4));

        // Add label
        this.add(new JLabel("Student Panel: " + student.getName()));

        // Add buttons of the tasks
        ArrayList<Task> tasks = getTasks(student, "currentLesson");
        addButtons(tasks);
    }

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

    public void addButtons(ArrayList<Task> tasks) {
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
    }
}
