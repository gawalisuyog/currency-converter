package finance.arvato.currencyconverter.apptests.features;

import finance.arvato.currencyconverter.apptests.util.CurrencyConverterUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Map;

import static finance.arvato.currencyconverter.apptests.util.AssertUtil.verifyAttributes;
import static finance.arvato.currencyconverter.apptests.util.CurrencyConverterUtil.getBaseCurrencyConverterAppURL;
import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyConverterSetpdefs {

    String currency1;
    String currency2;
    String amount;
    Response response;

    @When("convert below listed currencies")
    public void convertBelowListedCurrencies(DataTable dataTable) {
        Map<String, String> requestBody = dataTable.asMap(String.class, String.class);
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
