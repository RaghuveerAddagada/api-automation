package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DataUSAResponse {

    private List<DataIs> data;
    private List<SourceIs> source;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class DataIs {

        @JsonProperty("ID Nation")
        private String iDNation;

        @JsonProperty("Nation")
        private String nation;

        @JsonProperty("ID Year")
        private String idYear;

        @JsonProperty("Year")
        private String year;

        @JsonProperty("Population")
        private String population;

        @JsonProperty("Slug Nation")
        private String slugNation;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class SourceIs {

        private List<String> measures;
        private Annotations annotations;
        private String name;
        private List<String> substitutions;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Annotations {

        @JsonProperty("source_name")
        private String sourceName;

        @JsonProperty("source_description")
        private String sourceDescription;

        @JsonProperty("dataset_name")
        private String datasetName;

        @JsonProperty("dataset_link")
        private String datasetLink;

        @JsonProperty("table_id")
        private String tableId;

        private String topic;
        private String subtopic;
    }
}
