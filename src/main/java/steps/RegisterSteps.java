package steps;

import api.RegisterApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.RegisterRequestDto;
import model.RegisterResponseDto;
import util.ApiResult;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class RegisterSteps {
    private final RegisterApi registerApi = new RegisterApi();
    private RegisterRequestDto.RegisterRequestDtoBuilder requestBuilder;
    private ApiResult<RegisterResponseDto> result;

    @Given("Base URL is set")
    public void base_url_is_set() {
        requestBuilder = RegisterRequestDto.builder();
    }

    @Given("I set valid username {string}")
    public void setUsername(String username) {
        requestBuilder.username(username);
    }

    @And("I set valid password {string}")
    public void setPassword(String password) {
        requestBuilder.password(password);
    }

    @And("I set confirm password {string}")
    public void setConfirmPassword(String confirmPassword) {
        requestBuilder.confirmPassword(confirmPassword);
    }

    @When("I send POST request to {string}")
    public void sendPostRequest(String endpoint) {
        RegisterRequestDto request = requestBuilder.build();
        result = registerApi.sendRegisterRequest(request, endpoint);
    }

    @Then("the response code should be {int}")
    public void verifyResponseCode(int expectedCode) {
        if (result instanceof ApiResult.Success<RegisterResponseDto> success) {
            assertEquals(Integer.valueOf(expectedCode), success.data.getCode());
        } else if (result instanceof ApiResult.Error<?> error) {
            assertEquals(expectedCode, error.statusCode);
        } else {
            fail("Unexpected result type");
        }
    }
}
