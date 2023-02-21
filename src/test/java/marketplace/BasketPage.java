package marketplace;

import other.Constants;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BasketPage {

    public WebDriver driver;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Random random = new Random();

    @FindBy(id = Constants.CATEGORY_BTN)
    private WebElement category;

    @FindBy(xpath = Constants.SMARTPHONE_CATEGORY)
    private WebElement smartphoneCategory;

    @FindBy(xpath = Constants.PAGE_OF_PHONES)
    private WebElement pageOfPhones;

    @FindBy(className = Constants.BUY_BTN)
    private List<WebElement> chooseItemForBuy;

    @FindBy(xpath = Constants.ITEMS_FOR_GAMERS)
    WebElement itemsForGamers;

    @FindBy(xpath = Constants.GAME_CONSOLES)
    WebElement gameConcoles;

    @FindBy(xpath = Constants.BASKET_BTN)
    WebElement basketButton;

    @FindBy(className = Constants.PRICE_FOR_CART_PRODUCT)
    List<WebElement> priceForCartProduct;

    @FindBy(className = Constants.SUM_PRICE)
    WebElement sumPrice;

    @FindBy(id = Constants.CART_PRODUCTION_ACTION)
    WebElement cartProductionAction;

    @FindBy(xpath = Constants.DELETE_BTN)
    WebElement deleteButton;

    public void clickToCategoryButton() {
        try {
            category.click();
        } catch (StaleElementReferenceException e) {
            category.click();
        }
    }

    public String chooseSmartphoneCategory() {
        return smartphoneCategory.getAttribute(Constants.HREF);
    }

    public String choosePageOfPhones() {
        return pageOfPhones.getAttribute(Constants.HREF);
    }

    public void chooseItemForBuy() {
        try {
            chooseItemForBuy.get(random.nextInt(chooseItemForBuy.size())).click();
        } catch (StaleElementReferenceException e) {
            chooseItemForBuy.get(random.nextInt(chooseItemForBuy.size())).click();
        }
    }

    public String chooseItemsForGamers() {
        try {
            return itemsForGamers.getAttribute(Constants.HREF);
        } catch (StaleElementReferenceException e) {
            return itemsForGamers.getAttribute(Constants.HREF);
        }
    }

    public String chooseGameConsoles() {
        return gameConcoles.getAttribute(Constants.HREF);
    }

    public void clickToBasketButton() {
        try {
            basketButton.click();
        } catch (StaleElementReferenceException e) {
            basketButton.click();
        }
    }

    public void verifyPriceForCartProduct() {

        try {
            ArrayList<String> temp = new ArrayList<>();

            for (WebElement x : priceForCartProduct) {
                temp.add(x.getText()
                        .replace("₴", "")
                        .replace(" ", ""));
            }

            List<Integer> prices = temp.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            // Verify that all prices are calculated correctly
            if (sumList(prices) !=
                    Integer.parseInt(sumPrice.getText()
                            .replace("₴", "")
                            .replace(" ", ""))) {
                System.out.println("Sum price isn't the same");
            }
        } catch (StaleElementReferenceException e) {
            ArrayList<String> temp = new ArrayList<>();

            for (WebElement x : priceForCartProduct) {
                temp.add(x.getText()
                        .replace("₴", "")
                        .replace(" ", ""));
            }

            List<Integer> prices = temp.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // Verify that all prices are calculated correctly
            if (sumList(prices) !=
                    Integer.parseInt(sumPrice.getText()
                            .replace("₴", "")
                            .replace(" ", ""))) {
                System.out.println("Sum price isn't the same");
            }
        }

    }

    public static int sumList(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    public void chooseCartProductionAction() {
        try {
            cartProductionAction.click();
        } catch (StaleElementReferenceException e) {
            cartProductionAction.click();
        }
    }

    public void verifyDeleteItemButton() {
        try {
            if (!deleteButton.isDisplayed() || !deleteButton.isEnabled()) {
                System.out.println("Delete button isn't clickable");
            }
        } catch (StaleElementReferenceException e) {
            if (!deleteButton.isDisplayed() || !deleteButton.isEnabled()) {
                System.out.println("Delete button isn't clickable");
            }
        }
    }

}
