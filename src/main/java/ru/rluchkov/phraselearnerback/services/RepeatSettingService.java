package ru.rluchkov.phraselearnerback.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rluchkov.phraselearnerback.entities.RepeatSetting;
import ru.rluchkov.phraselearnerback.repositories.RepeatSettingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepeatSettingService {

    private final RepeatSettingRepository repeatSettingRepository;

    public List<RepeatSetting> getSettings() {
        return repeatSettingRepository.findAll();
    }
}
