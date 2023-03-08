package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenderApiResponse {

    private String name;
    private String gender;
    private float probability;
    private int count;
}
