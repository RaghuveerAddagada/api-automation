package com.backend.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public final class EmployeeCheckListPojo {

    private String id;

    @JsonProperty("ChecklistId")
    private String checklistId;

    @JsonProperty("Sections")
    private List<Section> sections = new ArrayList<>();


    @Data
    public static class Section {

        @JsonProperty("SectionId")
        private String sectionId;

        @JsonProperty("SectionName")
        private String sectionName;

        @JsonProperty("Items")
        private List<Item> items = new ArrayList<>();
    }

    @Data
    public static class Item {

        @JsonProperty("ItemId")
        private String itemId;

        @JsonProperty("ItemName")
        private String itemName;

        @JsonProperty("ItemPath")
        private String itemPath;

        @JsonProperty("AnswerTypes")
        private String answerTypes;

        @JsonProperty("Description")
        private String description;
    }

}
