package io.akem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tasks")
@NoArgsConstructor
public class Task {

    @Id
    @Getter
    @Setter
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(name = "desc")
    @NotBlank(message = "Task's description must not be empty")
    private String description;

    @Getter
    @Setter
    private boolean done;
}
