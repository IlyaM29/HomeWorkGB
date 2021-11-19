package ru.geekbrains.hw.level2.lesson8.server;

public interface AuthService {
    String getNickByLoginAndPassword(String login, String password);
}
