package homeschooltracker.gui;

import homeschooltracker.JButtonParentTask;
import homeschooltracker.content.Task;
import homeschooltracker.users.Parent;
import homeschooltracker.users.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ParentTaskGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;

    public ParentTaskGUI(Parent parent) {
        frame = new JFrame();

        // Build the Panel
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));

        // Get tasks for parent
        ArrayList<Student> students = parent.getChildren();

        // Iterate through children
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            // Add Child Labels
            Student student = studentIterator.next();
            JLabel childLabel = new JLabel("Prepare for " + student.getName());
            panel.add(childLabel);

            ArrayList<Task> childSubjectList = student.getTaskArrayList();
            addButtons(childSubjectList);
        }

        // Add the panel to the frame and finish setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Parent Tasks for " + parent.getName());
        frame.pack();
        frame.setVisible(true);
    }

    public void addButtons(ArrayList<Task> childSubjectList) {
        ArrayList<Task> childLessonList = new ArrayList<>();
        Iterator<Task> subjectIterator = childSubjectList.iterator();
        while (subjectIterator.hasNext()) {
            Task subject = subjectIterator.next();
            childLessonList.addAll(subject.getTasks(subject.getToPrepareTaskList()));
        }

        Iterator<Task> lessonIterator = childLessonList.iterator();
        while (lessonIterator.hasNext()) {
            Task lesson = lessonIterator.next();
            lesson.printParentTasks();

            // Add Button for Lesson's Tasks
            JButtonParentTask specialButton = new JButtonParentTask(lesson.getName(), lesson);
            panel.add(specialButton);
            specialButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JButtonParentTask tmpButton = (JButtonParentTask) event.getSource();
                    tmpButton.execute();
                }
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed: ActionEvent " + e);
    }
}
