package ru.geekbrains.hw.level2.lesson7.server;

public interface AuthService {
    String getNickByLoginAndPassword(String login, String password);
}
