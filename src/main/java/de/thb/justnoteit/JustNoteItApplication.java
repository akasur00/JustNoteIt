package de.thb.justnoteit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class JustNoteItApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustNoteItApplication.class, args);
    }

}
