package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


@Slf4j
public class Driver {
        private Driver(){}
        private static WebDriver driver;
        /**
         * This method returns desired WebDriver which is designated in <environment>.properties file.
         * That's why constructor is private, only one instance of web driver runs during whole process.
         * */
        public static WebDriver get(String env) throws WebDriverException {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            if (driver == null) {
                String browser = PropManager.getProperties(env,"browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(options);
                        driver.manage().window().maximize();
                        break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    options.addArguments("--headless=new");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                   break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless=new"));
                    driver.manage().window().maximize();
                    break;
                    case "edge":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Edge");
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        driver.manage().window().maximize();
                        break;

                    case "safari":
                        if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                            throw new WebDriverException("Your OS doesn't support Safari");
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver = new SafariDriver();
                        driver.manage().window().maximize();
                        break;

                    case "cloud" :
                        String username = PropManager.getProperties(env, "cloud_username");
                        String accesskey = PropManager.getProperties(env, "cloud_accesskey");
                        DesiredCapabilities capability = new DesiredCapabilities();
                        capability.setCapability(CapabilityType.BROWSER_NAME, browser);
                        capability.setCapability(CapabilityType.PLATFORM_NAME, PropManager.getProperties(env, "platform_name"));
                        capability.setCapability(CapabilityType.BROWSER_VERSION, PropManager.getProperties(env, "browser_version") );

                        capability.setCapability("build", "Cucumber Sample Build");

                        capability.setCapability("network", true);
                        capability.setCapability("video", true);
                        capability.setCapability("console", true);
                        capability.setCapability("visual", true);

                        String gridURL = "https://" + username + ":" + accesskey + "@<your cloud provider>/wd/hub";
//                    RemoteWebDriver connection = new RemoteWebDriver(new URL(gridURL), capability);
//                    log.info(String.valueOf(capability));
//                    log.info(String.valueOf(connection.getSessionId()));
                        break;
                    default:
                        log.error("No such a browser type");
                        break;
                }

            }

            return driver;
        }

        public static void close() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }

