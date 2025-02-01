package edu.wgu.d387_sample_code.translations;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@Component
public class DisplayMessage {

    @Autowired
    private MessageSource messageSource;

    public String getWelcomeMessage(Locale locale) {
        // Fetch the welcome message for the specified locale
        return messageSource.getMessage("welcome.message", null, locale);
    }

    public String[] fetchMessages() throws InterruptedException {
        String[] messages = new String[2]; // For English and French
        Thread threadUS = new Thread(() -> messages[0] = getWelcomeMessage(Locale.US));
        Thread threadFR = new Thread(() -> messages[1] = getWelcomeMessage(Locale.CANADA_FRENCH));

        // Start threads
        threadUS.start();
        threadFR.start();

        // Wait for both threads to finish
        threadUS.join();
        threadFR.join();

        return messages;
    }
}