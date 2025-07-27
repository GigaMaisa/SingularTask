package task2.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class ProductsPage extends BasePage {
    private final Locator cartBadge;
    private final Locator cartLink;

    public ProductsPage(Page page) {
        super(page);
        this.cartBadge = page.locator(".shopping_cart_badge");
        this.cartLink = page.locator(".shopping_cart_link");
    }

    public List<String> getAllProductNames() {
        return page.locator(".inventory_item_name").allInnerTexts();
    }

    public void addItemToCartByName(String itemName) {
        Locator item = page.locator(".inventory_item")
                .filter(new Locator.FilterOptions().setHasText(itemName))
                .locator("button");
        item.click();
    }

    public String getCartBadgeCount() {
        return cartBadge.innerText();
    }

    public void goToCart() {
        cartLink.click();
    }
}