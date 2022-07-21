package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExchangeRateResponse {

    private Double amount;
    private Double amountWithExchangeRate;
    private String originCurrency;
    private String destinationCurrency;
    private Double exchangeRate;

}
