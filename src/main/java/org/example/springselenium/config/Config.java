package org.example.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@ComponentScan("org.example.springselenium")
public class Config {

    @Bean
    @Profile("desktop")
    public WebDriver getDesktopDriver() {
        System.out.println("this is the desktop");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Bean
    @Profile("mobile")
    public WebDriver getMobileDriver() {
        System.out.println("This is the mobile");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
