package homeschooltracker;

import homeschooltracker.users.Parent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUI(Parent parent) {
        frame = new JFrame();

        JButton button = new JButton("Click Me");
        label = new JLabel("Number of clicks: 0");

        // Build the Panel
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        // Build the Button
        panel.add(button);
        button.addActionListener(this);

        // Build the Label
        panel.add(label);

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
        label.setText("Number of clicks: " + count);
    }
}
