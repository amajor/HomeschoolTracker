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

public class ParentPanel extends JPanel {
    public ParentPanel(Parent parent) {
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.setLayout(new GridLayout(0, 1));

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
                }
            });
        }
    }

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
                }
            });
        }
    }
}
