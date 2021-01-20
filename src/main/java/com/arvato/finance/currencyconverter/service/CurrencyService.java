package com.arvato.finance.currencyconverter.service;

import com.arvato.finance.currencyconverter.exception.InvalidRequestException;
import com.arvato.finance.currencyconverter.model.ConvertedResult;
import com.arvato.finance.currencyconverter.model.CurrencyConversionInput;
import com.arvato.finance.currencyconverter.model.FixerCurrencyExchangeRates;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyService {

    static RestTemplate restTemplate = new RestTemplate();

    public ConvertedResult convertCurrencyRates(CurrencyConversionInput request) {
        if (!StringUtils.hasLength(request.getCurrency1()) || !StringUtils.hasLength(request.getCurrency2()) || !StringUtils.hasLength(request.getAmount())
                || !(request.getCurrency1().length() == 3) || !(request.getCurrency2().length() == 3) || Integer.parseInt(request.getAmount()) < 0) {
            throw new InvalidRequestException("invalid request");
        }
        ConvertedResult convertedResult = new ConvertedResult();
        String url = "http://data.fixer.io/api/latest?access_key=f690e52aad1b3e748fc9991926466459";
        FixerCurrencyExchangeRates fixerCurrencyExchangeRates = restTemplate.getForObject(url, FixerCurrencyExchangeRates.class);
        if (fixerCurrencyExchangeRates != null) {
            if (fixerCurrencyExchangeRates.getError() == null) {
                Double currencyExchangeRate1 = fixerCurrencyExchangeRates.getRates().get(request.getCurrency1());
                Double currencyExchangeRate2 = fixerCurrencyExchangeRates.getRates().get(request.getCurrency2());
                Double relativeExchangeRate = currencyExchangeRate2 / currencyExchangeRate1;
                convertedResult.setConvertResult(relativeExchangeRate * Double.parseDouble(request.getAmount()));
                convertedResult.setAmount(request.getAmount());
                convertedResult.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")));
                convertedResult.setFrom(request.getCurrency1());
                convertedResult.setTo(request.getCurrency2());
                convertedResult.setRate(relativeExchangeRate);
            } else {
                convertedResult.setError(fixerCurrencyExchangeRates.getError());
            }
        }
        return convertedResult;

    }
}