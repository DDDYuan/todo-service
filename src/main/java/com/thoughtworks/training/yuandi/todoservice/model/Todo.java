package com.thoughtworks.training.yuandi.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {
    @Id
    @GeneratedValue
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
