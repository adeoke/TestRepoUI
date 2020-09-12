package org.example.springselenium;

import org.example.springselenium.config.Config;
import org.example.springselenium.bag.Example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


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
        @Autowired
        private WebDriver driver;

        @Test
        public void browserStart() {
            driver.get("http://www.bing.com");
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
