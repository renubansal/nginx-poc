package com.example.nginx.effectiveprice.controller;

import com.example.nginx.effectiveprice.domain.EffectivePrice;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Validated
@RestController
@RequestMapping(value = "/effective-price")
public class EffectivePriceController {

    @GetMapping(value = "/cc")
    public EffectivePrice getEffectivePriceForCC(@RequestParam String customerChoiceNumber) {
        return EffectivePrice.builder()
            .customerChoiceNumber(customerChoiceNumber)
            .effectiveDate(LocalDateTime.now().toString())
            .universalCustomerChoiceNumber("11-22")
            .brand("1")
            .market("US")
            .channel("RTL")
            .storeId("123")
            .countryCode("US")
            .currencyCode("USD")
            .regularPrice(BigDecimal.TEN)
            .markdownPrice(BigDecimal.valueOf(5.4))
            .effectivePrice(BigDecimal.valueOf(20.3))
            .priceStatus("R")
            .effectivePriceStatus("R")
            .build();
    }
}
