package finance.arvato.currencyconverter.apptests.util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertUtil {

    public static void assertJsonObject(JsonPath jsonPath, Map<String, String> expectedParametersMap) {
        for (Map.Entry<String, String> entry : expectedParametersMap.entrySet()) {
            assertThat(jsonPath.getString(entry.getKey())).isEqualTo(entry.getValue());
        }
    }

    public static void verifyAttributes(Response response, Map<String, String> expectedValues) {
        assertThat(response.jsonPath().getString("rate")).isNotEmpty();
        assertThat(response.jsonPath().getString("convert_result")).isNotEmpty();
        assertJsonObject(response.jsonPath(), expectedValues);
    }
}