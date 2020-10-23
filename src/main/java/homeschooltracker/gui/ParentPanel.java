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
            ArrayList<Task> childSubjectList = student.getTaskArrayList();
            addButtons(student.getName(), childSubjectList);
        }
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
        this.add(childPrepareLabel);

        Iterator<Task> lessonIterator = prepareLessonList.iterator();
        while (lessonIterator.hasNext()) {
            Task lesson = lessonIterator.next();
            lesson.printParentTasks();

            // Add Button for Lesson's Tasks
            JButtonParentToPrepareTask specialButton = new JButtonParentToPrepareTask(lesson.getName(), lesson);
            this.add(specialButton);
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
        this.add(childGradeLabel);

        Iterator<Task> gradeIterator = gradeLessonList.iterator();
        while (gradeIterator.hasNext()) {
            Task lesson = gradeIterator.next();
            lesson.printParentTasks();

            // Add Button for Lesson's Tasks
            JButtonParentToGradeTask specialButton = new JButtonParentToGradeTask(lesson.getName(), lesson);
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
