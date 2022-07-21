package com.example.demo.controller;

import com.example.demo.dto.ExchangeRateRequest;
import com.example.demo.dto.ExchangeRateResponse;
import com.example.demo.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService service;

    @GetMapping("/exchangeRate")
    public ExchangeRateResponse getChange(
            @RequestParam(name = "amount") double amount,
            @RequestParam(name = "originCurrency") String originCurrency,
            @RequestParam(name = "destinationCurrency") String destinationCurrency) {

        ExchangeRateRequest request = new ExchangeRateRequest(amount, originCurrency, destinationCurrency);

        return service.makeChange(request);
    }
}
