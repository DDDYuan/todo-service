package com.thoughtworks.training.yuandi.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    private int id;
    private String value;
    private boolean checked;
    private String timestamp;

    @JsonProperty
    private boolean visible() {
        return true;
    }

    @JsonProperty
    private boolean editable() {
        return false;
    }
}
