package marketplace;


import other.Constants;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FilterPage {

    public WebDriver driver;

    public FilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(id = Constants.CATEGORY_BTN)
    private WebElement category;

    @FindBy(xpath = Constants.FIRST_NAME_OF_LAPTOP)
    private WebElement firstNameOfLaptop;

    @FindBy(xpath = Constants.SECOND_NAME_OF_LAPTOP)
    private WebElement secondNameOfLaptop;

    @FindBy(xpath = Constants.THIRD_NAME_OF_LAPTOP)
    private WebElement thirdNameOfLaptop;

    @FindBy(className = Constants.LIST_OF_LAPTOPS)
    private List<WebElement> listOfLaptops;

    @FindBy(xpath = Constants.FROM_INPUT_FIELD)
    private WebElement fromInput;

    @FindBy(xpath = Constants.TO_INPUT_FIELD)
    private WebElement toInput;

    @FindBy(xpath = Constants.SUBMIT_BTN)
    private WebElement submitButton;


    public void clickToCategoryButton() {
        category.click();
    }

    public String chooseFirstLaptop() {
        try {
            return firstNameOfLaptop.getAttribute("href");
        } catch (StaleElementReferenceException e) {
            return firstNameOfLaptop.getAttribute("href");
        }
    }

    public String chooseSecondLaptop() {
        return secondNameOfLaptop.getAttribute("href");
    }

    public String chooseThirdLaptop() {
        return thirdNameOfLaptop.getAttribute("href");
    }

    public void setFromValue() {
        try {
            fromInput.clear();
            fromInput.sendKeys("10000");
        } catch (StaleElementReferenceException e) {
            fromInput.clear();
            fromInput.sendKeys("10000");
        }
    }

    public void SetToValue() {
//        webDriverWait.until(ExpectedConditions.stalenessOf(toInput));
        try {
            toInput.clear();
            toInput.sendKeys("35000");
        } catch (StaleElementReferenceException e) {
            toInput.clear();
            toInput.sendKeys("35000");
        }
    }

    public void clickToSubmitButton() {
        submitButton.click();
    }

    public void getElementList() {
        try {

            ArrayList<String> temp = new ArrayList<>();

            for (WebElement listOfLaptop : listOfLaptops) {
                temp.add(listOfLaptop.getText().replace("₴", "").replace(" ", ""));
            }

            List<Integer> prices = temp.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // Verify that all prices are within the selected range
            for (Integer price : prices) {
                if (price < Integer.parseInt(fromInput.getAttribute("value")) || price > Integer.parseInt(toInput.getAttribute("value"))) {
                    System.out.println("Prices isn't in range");
                }
            }
        } catch (StaleElementReferenceException e) {

            ArrayList<String> newList = new ArrayList<>();

            for (WebElement listOfLaptop : listOfLaptops) {
                newList.add(listOfLaptop.getText().replace("₴", "").replace(" ", ""));
            }

            List<Integer> prices = newList.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
// Verify that all prices are within the selected range
            for (Integer price : prices) {
                if (price < Integer.parseInt(fromInput.getAttribute("value")) || price > Integer.parseInt(toInput.getAttribute("value"))) {
                    System.out.println("Prices isn't in range");
                }
            }
        }


    }
}

