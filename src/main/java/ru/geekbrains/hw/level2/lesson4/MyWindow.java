package ru.geekbrains.hw.level2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class MyWindow extends JFrame {
    TextArea textArea = new TextArea();
    TextField textField = new TextField(35);
    Button button = new Button("Отправить");

    public MyWindow() {
        setTitle("Чат");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 370, 400);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        add(panel, BorderLayout.SOUTH);



        textArea.setEditable(false);
        add(textArea, BorderLayout.CENTER);
        panel.add(textField);
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.requestFocus();
                action();

            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    action();
                }
            }
        });

        setVisible(true);
        textField.requestFocus();
    }

    public void action() {
        if (Objects.equals(textArea.getText(), "")) {
            textArea.setText(textField.getText());
        } else {
            textArea.setText(textArea.getText() + "\n" + textField.getText());
        }
        textField.setText("");
    }
}
