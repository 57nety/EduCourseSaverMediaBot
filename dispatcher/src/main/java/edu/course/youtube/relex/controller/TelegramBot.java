package edu.course.youtube.relex.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private static String name;

    @Value("${bot.token}")
    private static String token;

    public TelegramBot() {
        super(token);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public void onUpdateReceived(Update update) {
        var originalMessage = update.getMessage();
        System.out.println(originalMessage.getText());
    }
}
