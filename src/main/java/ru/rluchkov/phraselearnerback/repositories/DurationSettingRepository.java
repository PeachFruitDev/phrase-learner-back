package ru.rluchkov.phraselearnerback.repositories;

import org.springframework.stereotype.Repository;
import ru.rluchkov.phraselearnerback.entities.DurationSetting;

@Repository
public interface DurationSettingRepository extends WithUUIDRepository<DurationSetting> {
}
