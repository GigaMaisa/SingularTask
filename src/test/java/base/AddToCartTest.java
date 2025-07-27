package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task2.page.*;

import java.util.List;

import static org.testng.Assert.*;
import static task2.constants.Constants.*;

public class AddToCartTest extends BaseTest {
    private CartPage cartPage;
    private ProductsPage productsPage;
    private LoginPage loginPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage overviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    @Override
    public void navigateToPage() {
        page.navigate(PAGE_URL);
    }

    @BeforeClass
    @Override
    public void setUpPageObjects() {
        cartPage = new CartPage(page);
        productsPage = new ProductsPage(page);
        loginPage = new LoginPage(page);
        checkoutPage = new CheckoutPage(page);
        overviewPage = new CheckoutOverviewPage(page);
        checkoutCompletePage = new CheckoutCompletePage(page);
    }

    @Test
    public void shouldAddMultipleProductsAndSeeThemInCart() {
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        assertTrue(page.url().contains("inventory"));
        List<String> productNames = productsPage.getAllProductNames();

        List<String> addedItems = productNames.subList(0, 2);
        for (String name : addedItems) {
            productsPage.addItemToCartByName(name);
        }

        assertEquals(productsPage.getCartBadgeCount(), "2");
        productsPage.goToCart();
        List<String> cartItemNames = cartPage.getCartItemNames();
        assertEqualsNoOrder(cartItemNames.toArray(), addedItems.toArray());
        cartPage.goToCheckout();

        checkoutPage.
                fillFirstName("Giga").
                fillLastName("Maisuradze").
                fillPostalCodeName("0179").
                clickContinueButton();

        List<String> overviewItems = overviewPage.getItemNames();

        assertEqualsNoOrder(overviewItems.toArray(), addedItems.toArray());
        overviewPage.clickFinish();
        assertTrue(checkoutCompletePage.isSuccessMessageVisible());
        assertTrue(checkoutCompletePage.isConfirmationContainerVisible());
    }
}