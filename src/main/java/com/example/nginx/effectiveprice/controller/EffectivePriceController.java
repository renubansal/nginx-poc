package com.example.nginx.effectiveprice.controller;

import com.example.nginx.effectiveprice.domain.EffectivePrice;
import com.example.nginx.effectiveprice.domain.Offer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.util.Collections.singletonList;

@Validated
@RestController
@RequestMapping(value = "/effective-price")
public class EffectivePriceController {

    @GetMapping(value = "/cc")
    public EffectivePrice getEffectivePriceForCC(@RequestParam String customerChoiceNumber) {
        Offer offer = Offer.builder()
            .description("offer desc")
            .startDate(LocalDateTime.now().toString())
            .endDate(LocalDateTime.now().toString())
            .type("R")
            .applicableTo("RR")
            .quantity("222")
            .value("2334").build();
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
            .offers(singletonList(offer))
            .build();
    }
}
