package ru.geekbrains.hw.level1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private JTextField textField;
    private int randomNumber;
    public int counter = 3;

    public MyWindow() {
        randomNumber = (int) (Math.random() * 10) + 1;

        setTitle("Угадай число");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300,300,600,160);
        setResizable(false);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);
        textField.setText("Программа загадала число от 1 до 10");
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Calibri", Font.PLAIN, 20);
        textField.setFont(font);
        textField.setEditable(false);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 10));
        add(buttonsPanel, BorderLayout.CENTER);

        JButton buttonRes = new JButton("Рестарт игры");
        add(buttonRes, BorderLayout.SOUTH);
        buttonRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomNumber = (int) (Math.random() * 10) + 1;
                counter = 3;
                textField.setText("Программа загадала новое число от 1 до 10");
            }
        });

        for (int i = 1; i <= 10 ; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(font);
            buttonsPanel.add(button);
            int buttonIndex = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tryToAnswer(buttonIndex);
                }
            });
        }

        setVisible(true);
    }

    public void tryToAnswer(int answer) {
        if (counter > 0) {
            if (answer > randomNumber) {
                textField.setText("Не угадали! Загаданое число меньше");
            } else if (answer < randomNumber) {
                textField.setText("Не угадали! Загаданное число больше");
            } else {
                textField.setText("Вы угодали!!! Ответ: " + randomNumber);
            }
            counter--;
        } else {
            textField.setText("Ходы закончились! Проигрыш!");
        }
    }
}
