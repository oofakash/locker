package main;

import main.actions.homeActions;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class home {

    public static JLabel page, header, midBorder, mid, footer;
    public static JButton optionsButton, homeButton, registerButton, addButton, lockButton;

    public static DefaultTableModel tableModel;
    public static JTable table;


    public static void setHome() {
        page = new JLabel();
        page.setSize(720,420);
        page.setBackground(Color.GRAY);
        page.setOpaque(true);
        page.setLayout(null);
        app.mainWindow.add(page);

        setHeader();
        addOptions();
        addBorder();
        setMid();
        addTable();
        setFooter();
        addRegister();
        addHome();
        addAdd();
        addLock();

        homeActions.addButton();
    }

    public static void setHeader() {
        header = new JLabel();
        header.setLayout(null);
        header.setLocation(0,0);
        header.setSize(720, 40);
        header.setBackground(Color.GRAY);
        header.setOpaque(true);

        page.add(header);
    }

    public static void addOptions() {
        optionsButton = new JButton("OPTIONS");
        optionsButton.setSize(90, 20);
        optionsButton.setLocation(500, 10);
        optionsButton.setFocusPainted(false);
        optionsButton.setFont(new Font("Arial", Font.PLAIN, 12));
//        optionsButton.setBackground(Color.GRAY);

        header.add(optionsButton);
    }

    public static void addHome() {
        homeButton = new JButton("HOME");
        homeButton.setSize(90, 20);
        homeButton.setLocation(600, 10);
        homeButton.setFocusPainted(false);
        homeButton.setFont(new Font("Arial", Font.PLAIN, 12));
//        optionsButton.setBackground(Color.GRAY);

        header.add(homeButton);
    }

    public static void addBorder() {
        midBorder = new JLabel();
        midBorder.setLocation(0,40);
        midBorder.setSize(704,320);
        midBorder.setBackground(Color.GRAY);
        midBorder.setOpaque(true);
        midBorder.setBorder(new LineBorder(Color.BLACK, 3));
        midBorder.setLayout(null);

        page.add(midBorder);
    }

    public static void setMid() {
        mid = new JLabel();
        mid.setLocation(3,3);
        mid.setSize(698,260);
        mid.setBackground(Color.WHITE);
        mid.setOpaque(true);
        mid.setLayout(null);

        midBorder.add(mid);
    }

    public static void addTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("PATH");
        tableModel.addColumn("STATUS");

        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(693,254);
        scrollPane.setLocation(3,3);
        scrollPane.getViewport().setBackground(Color.WHITE);
        mid.add(scrollPane);

        table.setRowHeight(34);
        table.setShowVerticalLines(false);
        table.setFocusable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(480);


        table.getTableHeader().setReorderingAllowed(false);

    }
    public static void setFooter() {
        footer = new JLabel();
        footer.setLocation(3,260);
        footer.setSize(698,57);
        footer.setBackground(Color.GRAY);
        footer.setOpaque(true);
        footer.setLayout(null);

        midBorder.add(footer);
    }

    public static void addRegister() {
        registerButton = new JButton("REGISTER");
        registerButton.setSize(100, 20);
        registerButton.setLocation(10, 20);
        registerButton.setFocusPainted(false);
        registerButton.setFont(new Font("Arial", Font.PLAIN, 12));
//        optionsButton.setBackground(Color.GRAY);

        footer.add(registerButton);
    }

    public static void addAdd() {
        addButton = new JButton("ADD");
        addButton.setSize(100, 20);
        addButton.setLocation(120, 20);
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("Arial", Font.PLAIN, 12));
//        optionsButton.setBackground(Color.GRAY);

        footer.add(addButton);
    }

    public static void addLock() {
        lockButton = new JButton("LOCK");
        lockButton.setSize(100, 20);
        lockButton.setLocation(550, 20);
        lockButton.setFocusPainted(false);
        lockButton.setFont(new Font("Arial", Font.PLAIN, 12));
//        optionsButton.setBackground(Color.GRAY);

        footer.add(lockButton);
    }



}
