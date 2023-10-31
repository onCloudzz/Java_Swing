import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class Start extends JFrame {

    public Start() {
        setTitle("asd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();


        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Start();
    }
}