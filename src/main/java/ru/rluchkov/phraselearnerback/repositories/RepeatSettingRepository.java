package ru.rluchkov.phraselearnerback.repositories;

import org.springframework.stereotype.Repository;
import ru.rluchkov.phraselearnerback.entities.RepeatSetting;

@Repository
public interface RepeatSettingRepository extends WithUUIDRepository<RepeatSetting> {
}
