package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.restassured.RestAssured;

public class Hooks {
    @Before
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After
    public void tearDown() {

    }
}