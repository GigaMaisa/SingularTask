package task2.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator zipCodeInput;
    private final Locator continueButton;

    public CheckoutPage(Page page) {
        super(page);
        this.firstNameInput = page.locator("#first-name");
        this.lastNameInput = page.locator("#last-name");
        this.zipCodeInput = page.locator("#postal-code");
        this.continueButton = page.locator("#continue");
    }

    public CheckoutPage fillFirstName(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    public CheckoutPage fillLastName(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    public CheckoutPage fillPostalCodeName(String postalCode) {
        zipCodeInput.fill(postalCode);
        return this;
    }

    public CheckoutPage clickContinueButton() {
        continueButton.click();
        return this;
    }
}