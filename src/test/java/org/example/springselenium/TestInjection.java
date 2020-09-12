package org.example.springselenium;

import org.example.springselenium.config.Config;
import org.example.springselenium.bag.Example;
import org.example.springselenium.helpers.ScreenshotHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Paths;

public class TestInjection {
    @ExtendWith(SpringExtension.class)
    @ContextConfiguration(classes = Config.class)
    @Nested
    @DisplayName("Test injection simple object")
    class ExampleInject {
        @Test
        public void hereWeGo(@Autowired Example example) {
            example.load();
        }
    }

    @ExtendWith(SpringExtension.class)
    @ContextConfiguration(classes = Config.class)
    @Nested
    @DisplayName("Test injection with selenium webdriver object")
    class Aut {
        private final String screenshotsDir = Paths.get(System.getProperty("user.dir"), "screenshots").toString();
        @Autowired
        private WebDriver driver;

        @Test
        public void browserStart() throws Exception {
            driver.get("http://www.bing.com");
            System.out.println("screenshotsDir: \n" + screenshotsDir);
            ScreenshotHelper.takeSnapShot(driver, screenshotsDir + "/image.png");
        }

        @AfterEach
        public void tearDown() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
