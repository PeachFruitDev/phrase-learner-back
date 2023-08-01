package ru.rluchkov.phraselearnerback.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rluchkov.phraselearnerback.entities.DurationSetting;
import ru.rluchkov.phraselearnerback.repositories.DurationSettingRepository;

@Service
@RequiredArgsConstructor
public class DurationSettingService {

    private final DurationSettingRepository durationSettingRepository;

    public DurationSetting getSettings() {
        return durationSettingRepository.findAll().get(0);
    }
}
