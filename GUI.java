package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(panel);

        JLabel label = new JLabel("Type in the colour of the words, and not the word text!");
        label.setPreferredSize(new Dimension(400,25));
        label.setFont(new Font("Serfis",Font.BOLD,15));
        label.setForeground(Color.WHITE);
        panel.add(label);
        JLabel start = new JLabel("                              Press enter to start");
        start.setPreferredSize(new Dimension(400,25));
        start.setFont(new Font("Start",Font.ITALIC,16));
        start.setForeground(Color.WHITE);
        panel.add(start);
        JLabel time = new JLabel("                                      Time left: ");
        time.setPreferredSize(new Dimension(400,25));
        time.setFont(new Font("Time",Font.ITALIC,16));
        time.setForeground(Color.white);
        panel.add(time);


        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 20));
        panel.add(textField);

        //setting the frame size
        frame.setSize(new Dimension(600, 400));
        //set the start position
        frame.setLocationRelativeTo(null);
        //set a default close action
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set a title
        frame.setTitle("ColourGame");
        //Disable resize
        frame.setResizable(false);
        frame.setVisible(true);
	// write your code here
    }
}
