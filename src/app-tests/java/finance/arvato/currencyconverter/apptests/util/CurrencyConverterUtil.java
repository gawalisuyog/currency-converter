package finance.arvato.currencyconverter.apptests.util;

import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static finance.arvato.currencyconverter.apptests.util.RestClient.getWithRequestBody;

public class CurrencyConverterUtil {

    static Properties prop;

    static {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(new File("./src/app-tests/resources/config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseCurrencyConverterAppURL() {
        return prop.getProperty("base-url");
    }

    public static Response convertCurrencies(String url, Map<String, String> requestBody) {
        url = url + "/convert";
        return getWithRequestBody(url, requestBody);
    }
}
