package edu.wgu.d387_sample_code.translations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class WelcomeController {

    @Autowired
    private DisplayMessage displayMessage;

    @GetMapping("/welcome")
    public String[] getWelcomeMessages(@RequestParam(value = "lang", defaultValue = "en-US") String lang) throws InterruptedException {
        // Return the messages in English and French
        return displayMessage.fetchMessages();
    }
}
