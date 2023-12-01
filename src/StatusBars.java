import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class StatusBars extends JPanel {
    public StatusBars() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Set BoxLayout along the Y-axis

        String[] statusBarData = {"Health", "Stamina", "Thirst"};
        Color[] statusBarColors = {new Color(150, 0, 0), new Color(150, 150, 0), new Color(0, 0, 150)};
        int[] widths = {150, 200, 250}; // Widths for the progress bars

        for (int i = 0; i < statusBarData.length; i++) {
            JProgressBar statusBar = new JProgressBar();
            statusBar.setStringPainted(true);
            statusBar.setForeground(statusBarColors[i]);
            statusBar.setString(statusBarData[i] + "???/100");
            statusBar.setValue(100 - i * 20);

            // Set the preferred width for each progress bar
            statusBar.setPreferredSize(new Dimension(widths[i], 15));
            statusBar.setVisible(true);

            // Add vertical spacing between bars
            if (i > 0) {
                add(Box.createRigidArea(new Dimension(0, 5))); // Add vertical gap between bars
            }

            add(statusBar);
        }
    }
}
