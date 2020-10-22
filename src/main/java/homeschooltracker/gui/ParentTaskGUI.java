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
            ArrayList<Task> childSubjectList = student.getTaskArrayList();
            addButtons(student.getName(), childSubjectList);
        }

        // Add the panel to the frame and finish setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Parent Tasks for " + parent.getName());
        frame.pack();
        frame.setVisible(true);
    }

    public void addButtons(String studentName, ArrayList<Task> childSubjectList) {
        ArrayList<Task> prepareLessonList = new ArrayList<>();
        ArrayList<Task> gradeLessonList = new ArrayList<>();
        Iterator<Task> subjectIterator = childSubjectList.iterator();
        while (subjectIterator.hasNext()) {
            Task subject = subjectIterator.next();
            prepareLessonList.addAll(subject.getTasks(subject.getToPrepareTaskList()));
            gradeLessonList.addAll(subject.getTasks(subject.getToGradeTaskList()));
        }

        String prepareLabelText = "";
        if (prepareLessonList.size() > 0) {
            prepareLabelText = "Prepare for " + studentName;
        } else {
            prepareLabelText = "-- No lessons to prepare for " + studentName + " --";
        }
        JLabel childPrepareLabel = new JLabel(prepareLabelText);
        panel.add(childPrepareLabel);

        Iterator<Task> lessonIterator = prepareLessonList.iterator();
        while (lessonIterator.hasNext()) {
            Task lesson = lessonIterator.next();
            lesson.printParentTasks();

            // Add Button for Lesson's Tasks
            JButtonParentToPrepareTask specialButton = new JButtonParentToPrepareTask(lesson.getName(), lesson);
            panel.add(specialButton);
            specialButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JButtonParentToPrepareTask tmpButton = (JButtonParentToPrepareTask) event.getSource();
                    tmpButton.execute();
                }
            });
        }

        String gradeLabelText = "";
        if (gradeLessonList.size() > 0) {
            gradeLabelText = "Grade for " + studentName;
        } else {
            gradeLabelText = "-- No lessons to grade for " + studentName + " --";
        }
        JLabel childGradeLabel = new JLabel(gradeLabelText);
        panel.add(childGradeLabel);

        Iterator<Task> gradeIterator = gradeLessonList.iterator();
        while (gradeIterator.hasNext()) {
            Task lesson = gradeIterator.next();
            lesson.printParentTasks();

            // Add Button for Lesson's Tasks
            JButtonParentToGradeTask specialButton = new JButtonParentToGradeTask(lesson.getName(), lesson);
            panel.add(specialButton);
            specialButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    JButtonParentToGradeTask tmpButton = (JButtonParentToGradeTask) event.getSource();
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
