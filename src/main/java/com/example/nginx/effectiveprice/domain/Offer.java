package com.example.nginx.effectiveprice.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Offer {

    private String description;
    private String startDate;
    private String endDate;
    private String type;
    private String applicableTo;
    private String quantity;
    private String value;
}
