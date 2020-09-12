package org.example.springselenium.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mobile")
public class ChromeMobileBrowser {

    @Bean
    public WebDriver getChromeDriver() {
        System.out.println("This is the mobile");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
