
import marketplace.BasketPage;
import marketplace.FilterPage;
import marketplace.SearchTheItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import other.Constants;

import java.util.concurrent.TimeUnit;

public class MarketPlaceTest {

    public static FilterPage filterPage;
    public static BasketPage basketPage;
    public static SearchTheItem searchTheItem;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty(Constants.WEBDRIVER_KEY, Constants.WEBDRIVER_VALUE);
        driver = new ChromeDriver();
        filterPage = new FilterPage(driver);
        basketPage = new BasketPage(driver);
        searchTheItem = new SearchTheItem(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.MARKETPLACE_URL);
    }

    @Test
    public void clickToCategoryButton() {
        filterPage.clickToCategoryButton();
        driver.get(Constants.LINK_NOTES_CATEGORY);
        driver.get(Constants.LINK_NOTES);
        driver.get(filterPage.chooseFirstLaptop());
        driver.get(filterPage.chooseSecondLaptop());
        driver.get(filterPage.chooseThirdLaptop());
        filterPage.setFromValue();
        filterPage.SetToValue();
        filterPage.clickToSubmitButton();
        filterPage.getElementList();
    }

    @Test
    public void VerifyBasket() {
        basketPage.clickToCategoryButton();
        driver.get(basketPage.chooseSmartphoneCategory());
        driver.get(basketPage.choosePageOfPhones());
        basketPage.chooseItemForBuy();
        basketPage.clickToCategoryButton();
        driver.get(basketPage.chooseItemsForGamers());
        driver.get(basketPage.chooseGameConsoles());
        basketPage.chooseItemForBuy();
        basketPage.clickToBasketButton();
        basketPage.verifyPriceForCartProduct();
        basketPage.chooseCartProductionAction();
        basketPage.verifyDeleteItemButton();
    }

    @Test
    public void searchTheItem() {
        searchTheItem.setSearchValue();
        searchTheItem.clickSearchButton();
        searchTheItem.verifyItemsAfterSearching();
    }
}