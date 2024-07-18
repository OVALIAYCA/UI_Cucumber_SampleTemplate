package pages;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.Environments;
import utilities.PropManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;

@Slf4j
public abstract class Base {

    public static final String env = Environments.STAGE.name();
    public static final WebDriver driver = Driver.get(env);

    public static final Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofMillis(Long.parseLong(PropManager.getProperties(env,"duration"))))
            .pollingEvery(Duration.ofMillis(1000))
            .ignoring(NoSuchElementException.class);
    public Actions actions=new Actions(Driver.get(env));
    public Faker faker=new Faker();
    public final SoftAssert softAssert=new SoftAssert();

    public void waitAndClick(WebElement element){
        long start = System.currentTimeMillis();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info("Clicked in {}ms", System.currentTimeMillis() - start);
    }

    public static void hardWait(int duration){

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
