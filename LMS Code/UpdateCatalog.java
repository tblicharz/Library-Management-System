package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCatalog extends JFrame implements ActionListener {

    Books books = new Books();

    private JFrame updateFrame = new JFrame();
    private JButton addButton = new JButton("Add Book");
    private JButton deleteButton = new JButton("Delete Book");
    private JPanel topPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JLabel label = new JLabel(("Update Book Catalog"));
    private JLabel label2 = new JLabel(("Click here to go back:"));
    private JTextField textField1 = new JTextField("Enter book title to add book here...");
    private JTextField textField2 = new JTextField("Enter book title to delete book here...");
    private JButton backButton = new JButton(("Go Back")); //back button


    public UpdateCatalog() {
        updateFrame.setTitle("UoR's Student Library Management System"); // set title for application
        updateFrame.setResizable(false); // prevents frame from being resized
        updateFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE)); // exits out of the application
        updateFrame.setVisible(true);
        updateFrame.setSize(650,400);

        addButton.setHorizontalAlignment(SwingConstants.CENTER);
        addButton.setVerticalAlignment(SwingConstants.CENTER);
        addButton.addActionListener(this);
        deleteButton.setHorizontalAlignment(SwingConstants.CENTER);
        deleteButton.setVerticalAlignment(SwingConstants.CENTER);
        deleteButton.addActionListener(this);
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setVerticalAlignment(SwingConstants.CENTER);
        backButton.addActionListener(this);

        // TOP PANEL
        updateFrame.add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 95, 30, 95));
        topPanel.setPreferredSize(new Dimension(500,85));
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(new Color(0x748f6a)); // top panel background color
        topPanel.add(label);
        label.setForeground(Color.white);
        label.setFont(new Font("Verdana", Font.BOLD,20));

        // BOTTOM PANEL
        bottomPanel.setBackground(new Color(0xC5D9BD)); // bottom panel background color
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(35, 95, 50, 95));
        bottomPanel.setLayout(new GridLayout(0,1));
        bottomPanel.add(textField1);
        bottomPanel.add(addButton);
        bottomPanel.add(textField2);
        bottomPanel.add(deleteButton);
        bottomPanel.add(label2);
        label2.setHorizontalAlignment(SwingConstants.CENTER); // center text
        label2.setVerticalAlignment(SwingConstants.CENTER); // center text
        label2.setForeground(new Color(0x1E2D4C));
        label2.setFont(new Font("Verdana", Font.PLAIN,14));
        bottomPanel.add(backButton);
        updateFrame.add(bottomPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton) {
            String title = textField1.getText();
            books.addBook(title);
            JDialog addBookDialog = new JDialog();
            addBookDialog.setSize(new Dimension(300,50));
            addBookDialog.setLayout(new GridLayout(2,1));
            addBookDialog.setLocationRelativeTo(updateFrame);
            addBookDialog.add(new JLabel(title + " "));
            addBookDialog.add(new JLabel("has been successfully added to the catalog! "));
            addBookDialog.setModal(true);
            addBookDialog.setResizable(true);
            addBookDialog.setVisible(true);
            System.out.println("The book has been successfully added to the catalog!");
        } else if (e.getSource()==deleteButton) {
            String title2 = textField2.getText();
            JDialog deleteBookDialog = new JDialog();
            deleteBookDialog.setSize(new Dimension(310,50));
            deleteBookDialog.setLayout(new GridLayout(2,1));
            deleteBookDialog.setLocationRelativeTo(updateFrame);
            deleteBookDialog.add(new JLabel(title2 + " "));
            deleteBookDialog.add(new JLabel("has been successfully deleted from the catalog! "));
            deleteBookDialog.setResizable(true);
            deleteBookDialog.setModal(true);
            deleteBookDialog.setVisible(true);
            System.out.println(title2 + " has been successfully deleted from the catalog!");
        } else if (e.getSource()==backButton) {
            updateFrame.dispose();
            LibraryGUI libraryGUI = new LibraryGUI();
        }
    }

}

