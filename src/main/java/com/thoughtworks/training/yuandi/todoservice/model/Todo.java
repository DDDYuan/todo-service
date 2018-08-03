package com.thoughtworks.training.yuandi.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE todo SET deleted = true WHERE id = ?")
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String value;
    private boolean checked;
    private Date timestamp;
    private int userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_id")
    private List<Task> tasks;

    @JsonProperty
    private boolean visible() {
        return true;
    }

    @JsonProperty
    private boolean editable() {
        return false;
    }


    @Builder.Default
    private boolean deleted = false;
}
