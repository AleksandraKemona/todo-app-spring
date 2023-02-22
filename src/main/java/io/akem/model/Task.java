package io.akem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @Getter
    private int id;

    @Getter
    @Setter
    @Column(name = "desc")
    private String description;

    @Getter
    @Setter
    private boolean done;
}
