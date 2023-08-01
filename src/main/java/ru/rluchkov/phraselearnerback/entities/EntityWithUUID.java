package ru.rluchkov.phraselearnerback.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@MappedSuperclass
@Getter
@EqualsAndHashCode(of = "id")
public class EntityWithUUID {

    @Id
    private final UUID id;

    public EntityWithUUID() {
        this.id = UUID.randomUUID();
    }

}
