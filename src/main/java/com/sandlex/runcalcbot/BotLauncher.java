package com.sandlex.runcalcbot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class BotLauncher {

    @PostConstruct
    public void launchBots() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotApi = new TelegramBotsApi();
        try {
            telegramBotApi.registerBot(new RunCalcBot());
        } catch (TelegramApiRequestException e) {
            log.error("Error while launching bot", e);
        }

    }
}
