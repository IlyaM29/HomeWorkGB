package ru.geekbrains.hw.level2.lesson7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    public static final int PORT = 8189;

    private final AuthService authService;
    private final List<ClientHandler> clients;

    public ChatServer() {

        this.authService = new SimpleAuthService();
        this.clients = new ArrayList<>();

        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            while (true) {
//                System.out.println("Сервер ожидает подключения");
                Socket socket = serverSocket.accept();
//                System.out.println("Клиент подключился");
                new ClientHandler(socket,this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler client : clients) {
            if (client.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public synchronized void broadcast(String msg) {
        for (ClientHandler client : clients) {
            client.sendMessage(msg);
        }
    }

    public synchronized void privateMsg(String nick, String msg) {
        for (ClientHandler client : clients) {
            if (client.getNick().equals(nick)) {
                client.sendMessage(msg);
            }
        }
    }
}
