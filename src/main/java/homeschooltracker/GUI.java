package homeschooltracker;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public GUI(String title) {
        JFrame frame = new JFrame();

        // Build the Panel
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));

        // Add the panel to the frame and finish setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }
}
