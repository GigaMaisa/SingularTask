package task2.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutCompletePage extends BasePage {

    private final Locator successMessage = page.locator(".complete-header"); // e.g., "Thank you for your order!"
    private final Locator confirmationContainer = page.locator(".checkout_complete_container");

    public CheckoutCompletePage(Page page) {
        super(page);
    }

    public boolean isSuccessMessageVisible() {
        return successMessage.isVisible();
    }

    public boolean isConfirmationContainerVisible() {
        return confirmationContainer.isVisible();
    }
}