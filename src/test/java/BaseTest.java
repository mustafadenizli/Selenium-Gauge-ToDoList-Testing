import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;



public class BaseTest {


    protected static final Logger log = Logger.getLogger(String.valueOf(BaseTest.class));
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeScenario
    public void setUp(ExecutionContext executionContext) throws Exception {
        log.info("proje calismaya basladi");
        String baseUrl = "https://todomvc.com/examples/vue/";

        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10,2000);
        driver.get(baseUrl);
    }

    public WebElement findElement(By by){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);

    }

    public void click(By by){
        findElement(by).click();
    }

    public void sendKeys(By by, String text){

        findElement(by).sendKeys(text);
    }

    public void Action(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }


    @AfterScenario
    public void afterScenario(){
        driver.quit();
        log.info("calisma sonlandi");
    }

}
