package ru.rluchkov.phraselearnerback.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table
@Entity
@Getter
@Setter
public class LearningEntity extends EntityWithUUID {

    @Column(nullable = false, unique = true)
    private String learningPassage;

    @Column(nullable = false)
    private String learningTerm;

    @Column(nullable = false)
    private LocalDate lastReviewed;

    @Column(nullable = false)
    private Integer reviewsCount;

    @Column
    private String comment;
}
