package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "origin_currency")
    private String originCurrency;

    @Column(name = "destination_currency")
    private String destinationCurrency;

    @Column(name = "exchange_rate")
    private Double exchangeRate;

}
