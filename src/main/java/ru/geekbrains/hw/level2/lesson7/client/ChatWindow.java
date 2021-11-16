package ru.geekbrains.hw.level2.lesson7.client;

import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {
    TextArea textArea = new TextArea();
    TextField textField = new TextField();
    Button button = new Button("Отправить");

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public ChatWindow() {
        ChatClient client = new ChatClient(this);
        visual(client);
    }

    private void visual(ChatClient client) {
        setTitle("Чат");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //(EXIT_ON_CLOSE); <-ошибка на сервере при закрытии крестиком
        int sizeWidth = 400;
        int sizeHeight = 500;
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        add(textArea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);

        textArea.setEditable(false);
        textField.addActionListener(e -> sendMsg(client));
        button.addActionListener(e -> sendMsg(client));

        setVisible(true);
        textField.requestFocus();
    }

    private void sendMsg(ChatClient client) {
        String msg = textField.getText();
//        addMessage(msg);
        client.sendMessage(msg);
        textField.setText("");
        textField.requestFocus();
    }

    public void addMessage(String msg) {
        textArea.append(msg + "\n");
    }
}
