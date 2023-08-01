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
public class RepeatSetting extends EntityWithUUID {
    @Column(nullable = false, unique = true)
    private Integer reviewOrder;
    @Column(nullable = false, unique = true)
    private Integer repeatDay;
    @Column
    private String comment;
}
