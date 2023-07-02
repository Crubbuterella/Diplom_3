import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pagemodels.LoginPage;
import pagemodels.MainPage;
import pagemodels.PersonalAccountPage;
import pagemodels.RegistrationPage;
import apis.UserAPI;
import models.User;

public class PersonalPageTests extends Driver {

    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    User user;
    PersonalAccountPage personalAccountPage;
    UserAPI userAPI;
    String name;
    String email;
    String password;

    @Before
    public void setUp() {
        webDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
        name = "Irina";
        email = "nikatulka@mail.ru";
        password = "884696156";
        user = new User(email, password, name);
        userAPI.createUser(user);
        mainPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
    }
    @Test
    @DisplayName("Переход по клику на - Личный кабинет")
    public void goToMyAccountTest() {
        mainPage.clickPersonalButton();
        personalAccountPage.waitForLoadMainPage();
        Assert.assertTrue("Вход в личный кабинет не выполнен", personalAccountPage.isProfileButtonVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на - Конструктор")
    public void enterByConstructorButtonTest() {
        mainPage.clickPersonalButton();
        personalAccountPage.waitForLoadMainPage();
        personalAccountPage.clickConstructorButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void enterConstructorByLogoTest() {
        mainPage.clickPersonalButton();
        personalAccountPage.waitForLoadMainPage();
        personalAccountPage.clickLogo();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке - Выйти")
    public void exitOnTheExitButtonTest() {
        mainPage.clickPersonalButton();
        personalAccountPage.waitForLoadMainPage();
        personalAccountPage.clickLogoutButton();
        loginPage.waitForLoad();
        Assert.assertTrue("Выход не произошел", loginPage.isEnterLabelVisible());
    }
    @After
    public void tearDown() {
        String accessToken = UserAPI.loginUser(new User(email,password)).then().extract().path("accessToken");
        if (accessToken != null) {
            UserAPI.deleteUser(accessToken);
        }
        driver.quit();
    }
}
