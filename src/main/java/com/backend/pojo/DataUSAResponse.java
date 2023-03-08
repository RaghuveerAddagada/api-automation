package com.backend.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public final class DataUSAResponse {
    private List<DataItem> data;
    private List<SourceItem> source;

    @Getter
    @Setter
    public static class DataItem{
        @JsonProperty("Nation")
        private String nation;

        @JsonProperty("Year")
        private String year;

        @JsonProperty("Population")
        private int population;

        @JsonProperty("Slug Nation")
        private String slugNation;

        @JsonProperty("ID Nation")
        private String idNation;

        @JsonProperty("ID Year")
        private int idYear;
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Annotations{
        private String topic;
        private String datasetName;
        private String datasetLink;
        private String tableId;
        private String sourceName;
        private String subtopic;
        private String sourceDescription;
    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class SourceItem{
        private List<String> measures;
        private List<Object> substitutions;
        private String name;
        private Annotations annotations;
    }
}