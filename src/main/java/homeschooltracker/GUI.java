package homeschooltracker;

import homeschooltracker.content.Task;
import homeschooltracker.users.Parent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class GUI implements ActionListener {

    private int count = 0;
    private JLabel countLabel;
    private JFrame frame;
    private JPanel panel;

    public GUI(Parent parent) {
        frame = new JFrame();

        JButton button = new JButton("Click Me");
        countLabel = new JLabel("Number of clicks: 0");

        // Build the Panel
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));

        // Add Child Labels
        JLabel childLabel = new JLabel(parent.getChild(0).getName());
        panel.add(childLabel);

        // Get tasks for parent
        ArrayList<Task> childLessonList = new ArrayList<>();
        ArrayList<Task> childSubjectList = parent.getChild(0).getTaskArrayList();

        Iterator<Task> subjectIterator = childSubjectList.iterator();
        while (subjectIterator.hasNext()) {
            Task subject = subjectIterator.next();
            childLessonList.addAll(subject.getTasks(subject.getTaskArrayList()));
        }

        Iterator<Task> lessonIterator = childLessonList.iterator();
        while (lessonIterator.hasNext()) {
            Task lesson = lessonIterator.next();
            lesson.printParentTasks();

            // Add Button for Lesson's Tasks
            JButton taskButton = new JButton(lesson.getName());
            panel.add(taskButton);
        }

        // Build the Button
        panel.add(button);
        button.addActionListener(this);

        // Build the Labels
        panel.add(countLabel);

        // Add the panel to the frame and finish setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Parent Tasks for " + parent.getName());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        countLabel.setText("Number of clicks: " + count);
    }
}
