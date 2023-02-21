package other;

public @interface Constants {

    //XPath
    String FROM_INPUT_FIELD = "/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/aside/rz-filter-stack/div[3]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-slider/form/fieldset/div/input[1]";
    String TO_INPUT_FIELD = "/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/aside/rz-filter-stack/div[3]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-slider/form/fieldset/div/input[2]";
    String SUBMIT_BTN = "/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div/aside/rz-filter-stack/div[3]/div/rz-scrollbar/div/div[1]/div/div/rz-filter-slider/form/fieldset/div/button";
    String SMARTPHONE_CATEGORY = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/rz-header-fat-menu/rz-fat-menu/div[2]/ul/li[2]/a";
    String ITEMS_FOR_GAMERS = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/rz-header-fat-menu/rz-fat-menu/div[2]/ul/li[3]/a";
    String GAME_CONSOLES = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[1]/section/ul/li[1]/rz-list-tile/div/a[2]";
    String BASKET_BTN = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button";
    String DELETE_BTN = "//*[@id=\"cartProductActions0\"]/ul/li[1]/rz-trash-icon/button";
    String SEARCH_INPUT_FIELD = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/div/div/input";
    String SEARCH_BTN = "/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/button";

    //Class
    String LIST_OF_LAPTOPS = "goods-tile__price-value";
    String PAGE_OF_PHONES = "/html/body/app-root/div/div/rz-super-portal/div/main/section/div[2]/rz-dynamic-widgets/rz-widget-list[1]/section/ul/li[1]/rz-list-tile/div/a[2]";
    String BUY_BTN = "goods-tile__buy-button";
    String PRICE_FOR_CART_PRODUCT = "cart-product__price";
    String SUM_PRICE = "cart-receipt__sum-price";
    String ITEMS_AFTER_SEARCHING = "goods-tile__title";

    //Id
    String FIRST_NAME_OF_LAPTOP = "//*[@data-id='ASUS']";
    String SECOND_NAME_OF_LAPTOP = "//*[@data-id='Dell']";
    String THIRD_NAME_OF_LAPTOP = "//*[@data-id='Xiaomi']";
    String CATEGORY_BTN = "fat-menu";
    String CART_PRODUCTION_ACTION = "cartProductActions0";

    //Other
    String WEBDRIVER_KEY = "webdriver.chrome.driver";
    String WEBDRIVER_VALUE = "C:\\Users\\smolt\\OneDrive\\Робочий стіл\\Java\\Chrome_driver\\chromedriver.exe";
    String MARKETPLACE_URL = "https://rozetka.com.ua/ua/";
    String HREF = "href";

    String LINK_NOTES_CATEGORY = "https://rozetka.com.ua/ua/computers-notebooks/c80253/";
    String LINK_NOTES = "https://rozetka.com.ua/ua/notebooks/c80004/";
}
