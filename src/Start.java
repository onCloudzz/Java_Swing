import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class Start extends JFrame {
    public Start() {
        setTitle("MainUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        c.add(new sideBar());

        setSize(1600, 900);
        setVisible(true);
    }

    class sideBar extends JPanel {
        public sideBar() {
            setSize(500, 900);
            setBackground(new Color(68,68,68));
            setLocation(1100,0);
        }
    }

    public static void main(String[] args) {
        new Start();
    }
}