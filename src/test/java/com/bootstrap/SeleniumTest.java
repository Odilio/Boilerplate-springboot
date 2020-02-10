package com.bootstrap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import com.bootstrap.springboot.Starter;

import io.github.bonigarcia.wdm.WebDriverManager;

@ContextConfiguration(classes=Starter.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    private WebDriver driver;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUpClass() throws Exception {
        WebDriverManager.chromedriver().version("78").setup();
    }
  

    @BeforeEach
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @AfterEach
    public  void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
  
    @Test
    public void helloPageHasTextHelloWorld() {
        driver.navigate().to(String.format("http://localhost:%s/hello", port));

        WebElement body = driver.findElement(By.tagName("body"));

        assertThat(body.getText(), containsString("Hello World!"));
    }
}