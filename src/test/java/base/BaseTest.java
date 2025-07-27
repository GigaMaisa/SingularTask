package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeSuite
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @BeforeMethod
    public abstract void navigateToPage();

    @BeforeClass
    public abstract void setUpPageObjects();

    @AfterSuite
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}