package finance.arvato.currencyconverter.apptests.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {

    private static RequestSpecification basicRequestSpec() {
        RequestLogSpecification log = RestAssured
                .given()
                .log();
        return log.all().contentType(getContentType());
    }

    private static ContentType getContentType() {
        return ContentType.fromContentType("application/json");
    }

    public static Response getWithRequestBody(String url, Map<String, String> requestBody) {
        return basicRequestSpec()
                .body(requestBody)
                .get(url)
                .then()
                .extract()
                .response();
    }
}
