package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindBook extends JFrame implements ActionListener {

    Catalog catalog = new Catalog();

    private JFrame findBookFrame = new JFrame();
    private JLabel label = new JLabel("Find books here");
    private JLabel label2 = new JLabel("What book are you looking for?");
    private JLabel label3 = new JLabel("Click here to go back:");
    private JTextField textField = new JTextField("Enter title, author, or ISBN...");
    private JPanel topPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JButton searchButton = new JButton("Search");
    private JButton backButton = new JButton("Go back");

    public FindBook() {

        findBookFrame.setTitle("UoR's Student Library Management System"); // set title for application
        findBookFrame.setResizable(false); // prevents frame from being resized
        findBookFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE)); // exits out of the application
        findBookFrame.setVisible(true);
        findBookFrame.setSize(650,400);


        // TOP PANEL
        findBookFrame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 95, 30, 95));
        topPanel.setPreferredSize(new Dimension(500, 85));
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(new Color(0x748f6a)); // top panel background color
        topPanel.add(label);
        label.setForeground(Color.white);
        label.setFont(new Font("Verdana", Font.BOLD, 20));

        // BOTTOM PANEL
        bottomPanel.setBackground(new Color(0xC5D9BD)); // bottom panel background color
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(35, 95, 50, 95));
        bottomPanel.setLayout(new GridLayout(0, 1));
        bottomPanel.add(label2);
        label2.setForeground(new Color(0x1E2D4C));
        label2.setFont(new Font("Verdana", Font.PLAIN, 14));
        label2.setHorizontalAlignment(SwingConstants.CENTER); // center text
        label2.setVerticalAlignment(SwingConstants.CENTER);
        bottomPanel.add(textField);
        bottomPanel.add(searchButton);
        label3.setForeground(new Color(0x1E2D4C));
        label3.setFont(new Font("Verdana", Font.PLAIN, 14));
        bottomPanel.add(label3);
        label3.setHorizontalAlignment(SwingConstants.CENTER); // center text
        label3.setVerticalAlignment(SwingConstants.CENTER);
        backButton.addActionListener(this);
        bottomPanel.add(backButton);
        findBookFrame.add(bottomPanel, BorderLayout.CENTER);
        searchButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            findBookFrame.dispose();
            LibraryGUI libraryGUI = new LibraryGUI();
        } else if (e.getSource() == searchButton) {
            String userInput = textField.getText();
            catalog.findBooks(userInput);
        }
    }
}