package com.example.nginx.effectiveprice.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class EffectivePrice {

    private String customerChoiceNumber;
    private String universalCustomerChoiceNumber;
    private String brand;
    private String market;
    private String channel;
    private String storeId;
    private String countryCode;
    private String currencyCode;
    private String effectiveDate;
    private BigDecimal regularPrice;
    private BigDecimal markdownPrice;
    private BigDecimal effectivePrice;
    private String priceStatus;
    private String effectivePriceStatus;
    private List<Offer> offers;
}
