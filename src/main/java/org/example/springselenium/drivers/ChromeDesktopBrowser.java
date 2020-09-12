package org.example.springselenium.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("desktop")
@Component
public class ChromeDesktopBrowser {

    @Bean
    public WebDriver getDesktopDriver() {
        System.out.println("this is the desktop");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
