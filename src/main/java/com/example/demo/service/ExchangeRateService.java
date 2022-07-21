package com.example.demo.service;

import com.example.demo.dto.ExchangeRateRequest;
import com.example.demo.dto.ExchangeRateResponse;
import com.example.demo.model.ExchangeRate;
import com.example.demo.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository repository;

    public ExchangeRateResponse makeChange(ExchangeRateRequest request) {
         Optional<ExchangeRate> exchangeRate = repository
                .findByOriginCurrencyAndDestinationCurrency(request.getOriginCurrency(), request.getDestinationCurrency());

         return exchangeRate
                 .map(rate -> ExchangeRateResponse.builder()
                         .amount(request.getAmount())
                         .amountWithExchangeRate(request.getAmount() * rate.getExchangeRate())
                         .originCurrency(request.getOriginCurrency())
                         .destinationCurrency(request.getDestinationCurrency())
                         .exchangeRate(rate.getExchangeRate())
                         .build()
                 )
                 .orElseThrow(() -> new ResponseStatusException(
                         HttpStatus.NOT_FOUND,
                         "No se encuentra almacenado en la BD un tipo de cambio para: "
                                 + request.getOriginCurrency()
                                 + " y "
                                 + request.getDestinationCurrency())
                 );
    }

}
