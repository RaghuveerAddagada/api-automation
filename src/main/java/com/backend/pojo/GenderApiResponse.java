package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenderApiResponse {

    private String name;
    private String gender;
    private float probability;
    private int count;
}
