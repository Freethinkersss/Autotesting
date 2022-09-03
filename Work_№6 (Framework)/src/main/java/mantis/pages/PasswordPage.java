package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "#remember-login")
    private WebElement checkboxRememberLogin;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        PageFactory.initElements(driver, this);
    }

    public void login(String password) {
        WebElement checkboxRememberLogin = driver.findElement(By.cssSelector("#remember-login"));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkboxRememberLogin).click().perform();
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
    }
}
