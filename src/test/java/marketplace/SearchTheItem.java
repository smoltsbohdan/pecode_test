package marketplace;

import other.Constants;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchTheItem {
    public WebDriver driver;

    public SearchTheItem(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = Constants.SEARCH_INPUT_FIELD)
    WebElement searchInputField;

    @FindBy(xpath = Constants.SEARCH_BTN)
    WebElement searchButton;

    @FindBy(className = Constants.ITEMS_AFTER_SEARCHING)
    List<WebElement> itemsAfterSearching;

    public void setSearchValue(){
        try {
            searchInputField.clear();
            searchInputField.sendKeys("Мобільний телефон Apple iPhone 14 Pro");
        }catch (StaleElementReferenceException e){
            searchInputField.clear();
            searchInputField.sendKeys("Мобільний телефон Apple iPhone 14 Pro");
        }
    }

    public void clickSearchButton(){
        try {
            searchButton.click();
        }catch (StaleElementReferenceException e){
            searchButton.click();
        }
    }

    public void verifyItemsAfterSearching(){
        ArrayList<String> correctlyItems = new ArrayList<>();
        ArrayList<String> differentItems = new ArrayList<>();

        for (WebElement element : itemsAfterSearching) {
            if(element.getText().contains(searchInputField.getAttribute("value"))){
                correctlyItems.add(element.getText());
            }else {
                differentItems.add(element.getText());
                System.out.println();
            }
        }
        System.out.println("These items are correctly displayed according to my searching request:");
        for (String correctlyItem : correctlyItems) {
            System.out.println(correctlyItem);
        }
        System.out.println("\n" + "These items are different from my search request:");
        for (String differentItem : differentItems) {
            System.out.println(differentItem);
        }

    }

}
