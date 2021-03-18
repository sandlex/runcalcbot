package com.sandlex.runcalcbot;

import com.sandlex.runcalc.Calculator;
import com.sandlex.runcalc.InvalidPaceBlockException;
import com.sandlex.runcalc.InvalidSchemaException;
import com.sandlex.runcalcbot.log.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Slf4j
@RequiredArgsConstructor
public class RunCalcBot extends TelegramLongPollingBot {

    private final LogService logService;

    /**
     * Method for receiving messages.
     *
     * @param update Contains a message from the user.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String receivedMessage = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), update.getMessage().getFrom().getId(), receivedMessage);
    }

    /**
     * Method for creating a message and sending it.
     *
     * @param chatId   chat id
     * @param personId telegram user id
     * @param receivedMessage        The String that you want to send as a message.
     */
    public synchronized void sendMsg(String chatId, Integer personId, String receivedMessage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        String[] parts = receivedMessage.trim().split(";");
        String result;
        String paceBlock = null;
        String schema = null;
        if (parts.length != 2) {
            result = "Incorrect message. More info https://sandlex.github.io/runcalcbot";
        } else {
            try {
                paceBlock = parts[0];
                schema = parts[1];
                result = Calculator.getEstimation(parts[0], parts[1]).toString();
            } catch (InvalidPaceBlockException | InvalidSchemaException e) {
                result = e.getMessage();
            }
        }
        sendMessage.setText(result);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Exception: " + e.toString());
            result = "Exception: " + e.getMessage();
        }
        logService.log(personId, paceBlock, schema, result);
    }

    /**
     * This method returns the bot's name, which was specified during registration.
     *
     * @return bot name
     */
    @Override
    public String getBotUsername() {
        return System.getenv("BOT_NAME");
    }

    /**
     * This method returns the bot's token for communicating with the Telegram server
     *
     * @return the bot's token
     */
    @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }
}
