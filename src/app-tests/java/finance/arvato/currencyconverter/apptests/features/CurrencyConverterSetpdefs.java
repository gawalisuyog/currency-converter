package finance.arvato.currencyconverter.apptests.features;

import finance.arvato.currencyconverter.apptests.util.CurrencyConverterUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static finance.arvato.currencyconverter.apptests.util.AssertUtil.verifyAttributes;
import static finance.arvato.currencyconverter.apptests.util.CurrencyConverterUtil.getBaseCurrencyConverterAppURL;
import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyConverterSetpdefs {

    String currency1;
    String currency2;
    String amount;
    Response response;

    @Given("Base currency is {string}")
    public void setBaseCurrency(String baseCurrency) {
        currency1 = baseCurrency;
    }

    @And("Target currency is {string}")
    public void setTargetCurrency(String targetCurrency) {
        currency2 = targetCurrency;
    }

    @When("I convert amount {string}")
    public void iConvertAmount(String amount) {
        this.amount = amount;

        Map<String, String> requestBody = new HashMap<>();

        requestBody.put("currency1", currency1);
        requestBody.put("currency2", currency2);
        requestBody.put("amount", amount);

        response = CurrencyConverterUtil.convertCurrencies(getBaseCurrencyConverterAppURL(), requestBody);
    }

    @And("The attributes received in the response body are correct")
    public void theAttributesReceiievedInTheResponseBodyAreCorrect(DataTable dataTable) {
        Map<String, String> expectedResponseBody = dataTable.asMap(String.class, String.class);
        verifyAttributes(response, expectedResponseBody);
    }

    @Then("response code is {int}")
    public void responseCodeIs(int statusCode) {
        assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

    @Then("conversion is successful")
    public void theConversionIsSuccessful() {
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }
}
