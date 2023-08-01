package ru.rluchkov.phraselearnerback.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class DurationSetting extends EntityWithUUID {

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Integer delay;

    @Column
    private String comment;
}
