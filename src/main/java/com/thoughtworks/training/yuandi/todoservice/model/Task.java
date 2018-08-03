package com.thoughtworks.training.yuandi.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE task SET deleted = true WHERE id = ?")
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String content;

    @Builder.Default
    private boolean deleted = false;
}
