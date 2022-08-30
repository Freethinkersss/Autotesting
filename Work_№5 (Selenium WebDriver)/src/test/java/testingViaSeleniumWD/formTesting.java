/*В ДЗ используем WebDriver Manager
-Реализовать логику с параметром запуска – минимум 3 вида браузеров
-Структурировать код с помощью аннотаций @Before / @After
-Написать автотест для формы на странице: https://demoqa.com/automation-practice-form
-Заполните все поля, нажать кнопку Submit, в открывшемся окне проверить, что данные заполнены верно
-При необходимости использовать wait*/

package testingViaSeleniumWD;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class formTesting {
    private WebDriver driver;

    @BeforeEach
    public void start() {
        String browser = System.getProperty("browser");

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }
    @AfterEach
    public void end() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void Test() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        String userName = "Ivan";
        firstName.sendKeys (userName);

        WebElement lastName = driver.findElement(By.id("lastName"));
        String userLastName = "Ivanov";
        lastName.sendKeys(userLastName);

        WebElement email = driver.findElement(By.id("userEmail"));
        String userEmail = "ivanov_ivan@mail.ru";
        email.sendKeys(userEmail);

        WebElement userGender = driver.findElement(By.cssSelector("input[value='Male']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(userGender).click().perform();

        WebElement number = driver.findElement(By.id("userNumber"));
        String userNumber = "0123456789";
        number.sendKeys(userNumber);

        WebElement userDateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        userDateOfBirth.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='1']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='1996']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.react-datepicker__day.react-datepicker__day--021"))).click();

        WebElement subjectsContainer = driver.findElement(By.id("subjectsInput"));
        subjectsContainer.click();
        String userSubjectsContainer = "Maths";
        subjectsContainer.sendKeys (userSubjectsContainer);
        subjectsContainer.sendKeys(Keys.ENTER);

        WebElement userHobbies = driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
        actions.moveToElement(userHobbies).click().perform();

        String pictureName = "pictureLeopard.jpg";
        File picture = new File("Work_№5 (Selenium WebDriver)/src/test/java/testingViaSeleniumWD/" + pictureName);
        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
        uploadPicture.sendKeys(picture.getAbsolutePath());

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        String userCurrentAddress = "Lenina 11, 55";
        currentAddress.sendKeys(userCurrentAddress);

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        String userState = "NCR";
        state.sendKeys(userState);
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        String userCity = "Delhi";
        city.sendKeys(userCity);
        city.sendKeys(Keys.ENTER);

        WebElement buttonSubject = driver.findElement(By.id("submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", buttonSubject);

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getText()).isEqualTo(userName + " " + userLastName);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText()).isEqualTo(userEmail);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText()).isEqualTo(userGender.getAttribute("value"));
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).getText()).isEqualTo(userNumber);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2)")).getText()).contains("21", "Feb", "1996");
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(2)")).getText()).isEqualTo(userSubjectsContainer);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(7) > td:nth-child(2)")).getText()).isEqualTo(userHobbies.getText());
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(8) > td:nth-child(2)")).getText()).isEqualTo(pictureName);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(9) > td:nth-child(2)")).getText()).isEqualTo(userCurrentAddress);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(10) > td:nth-child(2)")).getText()).isEqualTo(userState + " " + userCity);

        softAssert.assertAll();
    }
}