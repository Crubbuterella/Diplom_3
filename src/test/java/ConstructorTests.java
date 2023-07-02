import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pagemodels.MainPage;


public class ConstructorTests extends Driver {

    MainPage mainPage;

    @Before
    public void setUp() {
        webDriver();
        mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");
    }
    @Test
    @DisplayName("Переход в раздел Соусы")
    public void toTheSaucesSectionTest(){
        mainPage.clickSauceButton();
        Assert.assertTrue("Соусы не активны", mainPage.isSauceButtonActive());
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    public void toTheFillingSectionTest(){
        mainPage.clickFillingButton();
        Assert.assertTrue("Начинки не активны", mainPage.isFillingButtonActive());
    }

    @Test
    @DisplayName(" в раздел Булки")
    public void toTheBunSectionTest(){
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        Assert.assertTrue("Булки не активны", mainPage.isBunButtonActive());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
