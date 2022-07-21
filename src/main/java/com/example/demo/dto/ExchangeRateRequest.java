package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ExchangeRateRequest {

    private Double amount;
    private String originCurrency;
    private String destinationCurrency;

}
