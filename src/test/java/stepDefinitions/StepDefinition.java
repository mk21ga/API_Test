package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClasses.Currencies;
import resources.Utilities;

@RunWith(Cucumber.class)
public class StepDefinition extends Utilities {
	
	Response response;
	String basePath;
	String payLoad;;
    JsonPath js;
	int currency_count;
	
    @Given("^Exchange rate api$")
    public void exchange_rate_api() throws Throwable {
         basePath = RestAssured.basePath="https://v6.exchangerate-api.com/v6/1fc80820c72b0163bc9c7536/latest/USD";
    }

    @When("^User calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String resource, String httpMethod) throws Throwable {
     
    	if(httpMethod.equalsIgnoreCase("get"))
    	  response = given().when().get(basePath);
    }

    @Then("^Api call should be success with status code 200$")
    public void api_call_should_be_success_with_status_code_200() throws Throwable {
    	
        assertEquals(response.getStatusCode(), 200);
        System.out.println("Status Code is:-"+response.getStatusCode());
    }

    @Then("^Get the total currencies from response body$")
	public void get_the_total_currencies_from_response_body() throws Throwable {
    	
		payLoad = getPayload(response);
		js = new JsonPath(payLoad);
		currency_count = js.getInt("conversion_rates.size()");
		System.out.println("Number of currencies " + currency_count);

	}

    @Then("^Check if \"([^\"]*)\" currency is shown in response body$")
	public void check_if_something_currency_is_shown_in_response_body(String expectedCurrency) throws Throwable {

		Currencies curr = given().expect().defaultParser(Parser.JSON).when().get(basePath).as(Currencies.class);
		HashMap<String, Double> currencies = curr.getConversion_rates();
		for (String key : currencies.keySet()) {
			if (key.equalsIgnoreCase(expectedCurrency)) {
				System.out.println(expectedCurrency + " is present");
				assertEquals(key, expectedCurrency);
				break;
			}

		}

	}

}
