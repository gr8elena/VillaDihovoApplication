package com.example.villadihovo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ServiceForBeveragesDto implements Serializable {

    private String full_name;
    private String service_type;
    private String beverage_type;
    private float price;
}
