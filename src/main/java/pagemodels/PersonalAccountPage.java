package pagemodels;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PersonalAccountPage extends BasePage {

    private By constructorButtonLocator = By.xpath("//p[text()='Конструктор']");
    private By logoLocator = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");
    private By profileButtonLocator = By.xpath("//a[@href='/account/profile']");
    private By logoutButtonLocator = By.xpath("//li[@class='Account_listItem__35dAP']/button");
    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoadMainPage() {
        waitForVisibility(profileButtonLocator);
    }

    @Step("Проверка видимости кнопки 'Профиль'")
    public boolean isProfileButtonVisible() {
        return driver.findElement(profileButtonLocator).isDisplayed();
    }

    @Step("Клик на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorButtonLocator).click();
    }

    @Step("Клик на логотип")
    public void clickLogo() {
        driver.findElement(logoLocator).click();
    }

    @Step("Клик на 'Выйти'")
    public void clickLogoutButton() {
        driver.findElement(logoutButtonLocator).click();
    }
}

