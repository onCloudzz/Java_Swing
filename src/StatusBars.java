import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class StatusBars extends JPanel {
    public StatusBars() {
        setLayout(new GridLayout(3, 1, 0, 5));

        String[] statusBarData = {"Health", "Stamina", "Thirst"};
        Color[] statusBarColors = {new Color(150, 0, 0), new Color(150, 150, 0), new Color(0, 0, 150)};

        for (int i = 0; i < statusBarData.length; i++) {
            JProgressBar statusBar = new JProgressBar();
            statusBar.setString(statusBarData[i]);
            statusBar.setBackground(statusBarColors[i]);
            statusBar.setStringPainted(true);
            add(statusBar);
        }

        int rightPadding = 200;
        setBorder(new EmptyBorder(0, 0, 0, rightPadding));
    }
}
