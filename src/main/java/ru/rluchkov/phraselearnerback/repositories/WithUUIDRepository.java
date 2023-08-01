package ru.rluchkov.phraselearnerback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rluchkov.phraselearnerback.entities.EntityWithUUID;

import java.util.UUID;

public interface WithUUIDRepository<T extends EntityWithUUID> extends JpaRepository<T, UUID> {
}
