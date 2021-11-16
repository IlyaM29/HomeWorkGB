package ru.geekbrains.hw.level2.lesson7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private final Socket socket;
    private final ChatServer server;
    private final DataInputStream in;
    private final DataOutputStream out;
    private String nick;


    public ClientHandler(Socket socket, ChatServer server) {
        try {
            this.nick = "";
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    authenticate();
                    readMessages();
                } finally {
                    closeConnection();
                }
            }).start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            server.unsubscribe(this);
            server.broadcast(nick + " вышел из чата");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void authenticate() {
        while (true) {
            try {
                final String str = in.readUTF();
                if (str.startsWith("/auth")) {
                    final String[] split = str.split("\\s");
                    final String nick = server.getAuthService().getNickByLoginAndPassword(split[1], split[2]);
                    if (nick != null) {
                        if (!server.isNickBusy(nick)) {
                            sendMessage("/authok " + nick);
                            this.nick = nick;
                            server.subscribe(this);
                            server.broadcast(this.nick + " зашел в чат");
                            break;
                        } else {
                            sendMessage("Учетная запись уже используется");
                        }
                    } else {
                        sendMessage("Неверные логин и пароль");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        try {
            System.out.println("SERVER: Send message to " + nick);
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessages() {
        while (true) {
            try {
                final String msg = in.readUTF();

                if (msg.startsWith("/w")) {
                    final String[] split = msg.split("\\s");
                    String substring = msg.substring(4 + split[1].length());
                    if (server.isNickBusy(split[1])) {
                        server.privateMsg(nick, "ЛС для " + split[1] + ": " + substring);
                        server.privateMsg(split[1], "ЛС от " + nick + ": " + substring);
                    } else {
                        server.privateMsg(nick, "Участник " + split[1] + " отсутствует в чате");
                    }
                } else {
                    server.broadcast(nick + ": " + msg);
                }
                if (msg.equals("/end")) {
                    server.privateMsg(nick, "/end");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNick() {
        return nick;
    }
}