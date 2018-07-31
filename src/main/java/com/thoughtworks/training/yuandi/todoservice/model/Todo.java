package com.thoughtworks.training.yuandi.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    private int id;
    private String value;
    private boolean checked;

    @JsonProperty
    private boolean visible() {
        return true;
    }

    @JsonProperty
    private boolean editable() {
        return false;
    }

    @JsonProperty
    private String timestamp() {
        return DateFormat.getDateTimeInstance().format(new Date());
    }
}
