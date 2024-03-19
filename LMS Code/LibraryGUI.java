package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI implements ActionListener {

    private JFrame guiFrame = new JFrame();
    private JLabel label = new JLabel(("Welcome to the"));
    private JLabel label2 = new JLabel("University of Rizz");
    private JLabel label3 = new JLabel("Student Library Management System");
    private JLabel label4 = new JLabel(("Click one of the options below to get started:"));
    private JButton updateButton = new JButton("Update Book Catalog"); // creates update catalog button
    private JButton findBookButton = new JButton("Find Book"); // creates find book button
    private JButton findPatronButton = new JButton("Find Patron"); // creates find patron button
    private JButton reportsButton = new JButton("Check Today's Report"); // creates generate reports button
    private JPanel topPanel = new JPanel(); // top panel with welcome title
    private JPanel bottomPanel = new JPanel(); // bottom panel

    public LibraryGUI(){

        // FRAME (WINDOW)
        guiFrame.setTitle("UoR's Student Library Management System"); // set title for application
        guiFrame.setResizable(false); // prevents guiFrame from being resized
        guiFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));// exits out of the application
        guiFrame.setVisible(true); // make guiFrame visible
        guiFrame.setSize(650,400);

        // COMPONENTS ON TOP PANEL
        label.setForeground(Color.white);
        label.setFont(new Font("Verdana", Font.BOLD,16));
        label2.setForeground(new Color(0x1E2D4C));
        label2.setFont(new Font("Verdana", Font.BOLD, 16));
        label3.setForeground(Color.white);
        label3.setFont(new Font("Verdana", Font.BOLD,16));

        // ON BOTTOM PANEL
        label4.setHorizontalAlignment(SwingConstants.CENTER); // center text
        label4.setVerticalAlignment(SwingConstants.CENTER); // center text
        label4.setForeground(new Color(0x1E2D4C));
        label4.setFont(new Font("Verdana", Font.PLAIN,10));

        // BUTTONS
        updateButton.addActionListener(this);
        updateButton.setFont(new Font("Verdana", Font.PLAIN, 13));
        findBookButton.addActionListener(this);
        findBookButton.setFont(new Font("Verdana", Font.PLAIN, 13));
        findPatronButton.addActionListener(this);
        findPatronButton.setFont(new Font("Verdana", Font.PLAIN, 13));
        reportsButton.addActionListener(this);
        reportsButton.setFont(new Font("Verdana", Font.PLAIN, 13));

        // TOP PANEL
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 95, 30, 95));
        topPanel.add(label); // welcome
        topPanel.add(label2); // welcome
        topPanel.add(label3); // welcome
        topPanel.setBackground(new Color(0x748f6a)); // top panel background color
        topPanel.setPreferredSize(new Dimension(500,85));

        // BOTTOM PANEL
        bottomPanel.setBackground(new Color(0xC5D9BD)); // bottom panel background color
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(35, 95, 50, 95));
        bottomPanel.setLayout(new GridLayout(0,1));
        bottomPanel.add(label4);
        bottomPanel.add(updateButton); // add buttons to bottom panel
        bottomPanel.add(findBookButton); // add buttons to bottom panel
        bottomPanel.add(findPatronButton); // add buttons to bottom panel
        bottomPanel.add(reportsButton); // add buttons to bottom panel

        // ADDING COMPONENTS TO FRAME
        guiFrame.add(bottomPanel, BorderLayout.CENTER);
        guiFrame.add(topPanel, BorderLayout.NORTH);

    }

    // when button is clicked, new windows open
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==updateButton){
            guiFrame.dispose(); // dispose of previous guiFrame when update catalog button is pressed
            UpdateCatalog updateWindow = new UpdateCatalog();
        } else if (e.getSource()==findBookButton){
            guiFrame.dispose();
            FindBook findBookWindow = new FindBook();
        } else if (e.getSource()==findPatronButton){
            guiFrame.dispose();
            FindPatron findPatronWindow = new FindPatron();
        } else if(e.getSource()==reportsButton){
            guiFrame.dispose();
            GenerateReports reportsWindow = new GenerateReports();
        }

    }
}
