package ru.zero.graphics.SWING;

import ru.zero.game_logic.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    public static JFrame gamePanel;
    private static final int SIZE_WEIGHT = 300;
    private static final int SIZE_HEIGHT = 300;
    public Gui(Field field) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - SIZE_WEIGHT) / 2;
        int locationY = (screenSize.height - SIZE_HEIGHT) / 2;

//        Field field1 = field;
        gamePanel = new JFrame("TicTacToe");
        gamePanel.setSize(300, 360);
        gamePanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gamePanel.setLayout(new BorderLayout());

        Font font = new Font("Verdana", Font.PLAIN, 11);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setSize(gamePanel.getWidth(), 50);

        JButton restartButton = new JButton("RESTART");
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);

        JMenuItem restartMenu = new JMenuItem("Restart");
        restartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("This is restart from MENU");
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("This is restart from BUTTON");
            }
        });

        JMenuItem aboutMenu = new JMenuItem("About");
        aboutMenu.setFont(font);

        JMenuItem exitMenu = new JMenuItem("Exit");
        exitMenu.setFont(font);
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(gamePanel, "Program \"Tic-Tae-Toi\"");
            }
        });

        fileMenu.add(restartMenu);
        fileMenu.add(aboutMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenu);

        menuBar.add(fileMenu);

        GraphicField gField = new GraphicField(field);
        restartMenu.addActionListener(gField);
        restartButton.addActionListener(gField);

        topPanel.add(menuBar);
        topPanel.add(restartButton);

        gamePanel.setBounds(locationX, locationY, SIZE_WEIGHT, SIZE_HEIGHT);
        gamePanel.getContentPane().add(topPanel, BorderLayout.NORTH);

        gamePanel.add(gField);
        gamePanel.setVisible(true);
    }

}