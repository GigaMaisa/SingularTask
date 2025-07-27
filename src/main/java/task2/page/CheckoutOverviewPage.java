package task2.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    private final Locator itemNames = page.locator(".inventory_item_name");
    private final Locator finishButton = page.locator("#finish");

    public CheckoutOverviewPage(Page page) {
        super(page);
    }

    public List<String> getItemNames() {
        return itemNames.allInnerTexts();
    }

    public void clickFinish() {
        finishButton.click();
    }
}