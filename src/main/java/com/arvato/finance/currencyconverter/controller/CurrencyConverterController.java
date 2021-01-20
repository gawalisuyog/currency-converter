package com.arvato.finance.currencyconverter.controller;

import com.arvato.finance.currencyconverter.model.CurrencyConversionInput;
import com.arvato.finance.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencyconverter/api")
public class CurrencyConverterController {

    @Autowired
    CurrencyService conversionService;

    // endpoint for conversion of currencies
    @GetMapping(path = "/convert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> convertCurrencies(@RequestBody CurrencyConversionInput request) {
        return ResponseEntity.ok(conversionService.convertCurrencyRates(request));
    }
}