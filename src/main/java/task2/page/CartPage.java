package task2.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class CartPage extends BasePage {

    private final Locator itemNames;
    private final Locator checkoutButton;

    public CartPage(Page page) {
        super(page);
        this.itemNames = page.locator(".inventory_item_name");
        this.checkoutButton = page.locator("#checkout");
    }

    public List<String> getCartItemNames() {
        return itemNames.allInnerTexts();
    }

    public void goToCheckout() {
        checkoutButton.click();
    }
}