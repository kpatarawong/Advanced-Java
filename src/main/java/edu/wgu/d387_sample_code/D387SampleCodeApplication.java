package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.translations.DisplayMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);


		// Create instances of DisplayMessage for different locales
		DisplayMessage displayMessage = new DisplayMessage();

		// Create threads for different locales
		Thread threadUS = new Thread(() -> {
			Locale locale = Locale.US;
			String message = displayMessage.getWelcomeMessage(locale);
			System.out.println("US Thread: " + message);
		});

		Thread threadFR = new Thread(() -> {
			Locale locale = Locale.CANADA_FRENCH; // This represents fr_CA
			String message = displayMessage.getWelcomeMessage(locale);
			System.out.println("FR Thread: " + message);
		});

		// Start threads
		threadUS.start();
		threadFR.start();
	}
}
