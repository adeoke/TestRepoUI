package org.example.springselenium;

import org.example.springselenium.config.Config;
import org.example.springselenium.bag.Example;
import org.example.springselenium.helpers.AuthHelper;
import org.example.springselenium.helpers.ScreenshotHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Paths;

public class TestInjection {
    @ExtendWith(SpringExtension.class)
    @ContextConfiguration(classes = Config.class)
    @Nested
    @DisplayName("Test injection with selenium WebDriver object")
    class Aut {
        private final String screenshotsDir = Paths.get(System.getProperty("user.dir"), "screenshots").toString();
        @Autowired
        private WebDriver driver;

        @Value("${url.path}")
        private String urlPath;

        @Autowired
        private AuthHelper authHelper;

        @Test
        public void browserStart() throws Exception {
            String tok = authHelper.getDetailsForUser();
            driver.get(urlPath + "?token=" + tok);
            driver.findElement(By.cssSelector("#submissionDrafter")).click();

            //here come the hacks
            //firstly, I shouldn't have to cast to a JavascriptExecutor to interact with the DOM, but here i have to
            //You can attempt to bypass this by using for example
            //driver.fineElement(By.cssSelector("#handleAddOtherPriority")).click();
            //but that does not work for all browsers consistently.

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement declarationContainer = driver.findElement(By.cssSelector("#declaration"));
            js.executeScript("arguments[0].scrollIntoView();", declarationContainer);

            WebElement addPriorityButton = driver.findElement(By.cssSelector("#handleAddOtherPriority"));
            js.executeScript("arguments[0].click();", addPriorityButton);

            //next is to expand the drop down and select one of hte options for example (Regional, National, International)

//            ScreenshotHelper.takeSnapShot(driver, screenshotsDir + "/image.png");
        }

        @AfterEach
        public void tearDown() {
            //sleep just so that yuo can see what is happening. Delete if not required.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
