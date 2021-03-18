package com.sandlex.runcalcbot;

import com.sandlex.runcalcbot.log.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@RequiredArgsConstructor
public class BotLauncher {

    private final LogService logService;

    @PostConstruct
    public void launchBots() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotApi = new TelegramBotsApi();
        try {
            telegramBotApi.registerBot(new RunCalcBot(logService));
        } catch (TelegramApiRequestException e) {
            log.error("Error while launching bot", e);
        }

    }
}
