import javax.swing.*;
import java.awt.*;
import java.io.*;


public class GUI extends  JFrame {
    private JTextArea text;
    public GUI (){

        text = new JTextArea(50, 10);
        PrintStream printStream = new PrintStream(new CustomOutputStream(text));
        PrintStream standardOut = System.out;
        PrintStream standardErr = System.err;

        standardOut = System.out;

        System.setOut(printStream);
        System.setErr(printStream);

        JFrame frame=new JFrame();

        text.setBorder(BorderFactory.createEmptyBorder(50, 20, 10, 500));
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        text.setFont(font);
        text.setForeground(Color.white);
        text.setBackground(Color.darkGray);

        frame.add(text, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Router Connections");
        frame.pack();
        frame.setVisible(true);

    }


}
