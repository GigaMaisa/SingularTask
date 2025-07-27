package task2.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private final Locator usernameField = page.locator("#user-name");
    private final Locator passwordField = page.locator("#password");
    private final Locator loginButton = page.locator("#login-button");

    public LoginPage(Page page) {
        super(page);
    }

    public void login(String username, String password) {
        usernameField.fill(username);
        passwordField.fill(password);
        loginButton.click();
    }
}