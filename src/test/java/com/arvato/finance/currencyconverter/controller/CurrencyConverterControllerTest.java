package com.arvato.finance.currencyconverter.controller;

import com.arvato.finance.currencyconverter.model.ConvertedResult;
import com.arvato.finance.currencyconverter.model.CurrencyConversionInput;
import com.arvato.finance.currencyconverter.service.CurrencyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CurrencyConverterController.class)
public class CurrencyConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CurrencyService currencyService;

    ConvertedResult convertedResult = new ConvertedResult("01-14-2021 20:45:00", "AUD", "NOK", "10", 6.589566971388368, 65.89566971388368);

    String exampleConversionResult = "{\"time\":\"01-14-2021 20:45:00\",\"from\":\"AUD\",\"to\":\"NOK\",\"amount\":\"10\",\"rate\":\"6.589566971388368\",\"convert_result\":\"65.89566971388368\"}";

    @Test
    public void convertCurrencies() throws Exception {

        Mockito.when(currencyService.convertCurrencyRates(Mockito.any(CurrencyConversionInput.class))).thenReturn(convertedResult);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/currencyconverter/api/convert").contentType("application/json").accept(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"currency1\": \"AUD\",\n" +
                        "    \"currency2\": \"NOK\",\n" +
                        "    \"amount\": \"10\"\n" +
                        "}");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"time\":\"01-14-2021 20:45:00\",\"from\":\"AUD\",\"to\":\"NOK\",\"amount\":\"10\",\"rate\":6.589566971388368,\"convert_result\":65.89566971388368}";
        Assert.assertEquals(expected, result.getResponse()
                .getContentAsString());
    }
}