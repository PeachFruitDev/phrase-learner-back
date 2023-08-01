package ru.rluchkov.phraselearnerback.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.rluchkov.phraselearnerback.dto.LearningEntitiesTodayDto;
import ru.rluchkov.phraselearnerback.dto.LearningEntityDto;
import ru.rluchkov.phraselearnerback.entities.LearningEntity;
import ru.rluchkov.phraselearnerback.entities.RepeatSetting;
import ru.rluchkov.phraselearnerback.mappers.LearningEntityMapper;
import ru.rluchkov.phraselearnerback.repositories.LearningEntityRepository;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class LearningEntityService {

    private final LearningEntityMapper learningEntityMapper;
    private final LearningEntityRepository learningEntityRepository;
    private final DurationSettingService durationSettingService;
    private final RepeatSettingService repeatSettingService;

    public void add(LearningEntityDto learningEntityDto) {
        var entity = learningEntityMapper.toEntity(learningEntityDto);
        entity.setReviewsCount(0);
        entity.setLastReviewed(LocalDate.now());
        learningEntityRepository.save(entity);
    }

    public void delete(UUID id) {
        learningEntityRepository.deleteById(id);
    }

    public void review(UUID id) {
        var entity = learningEntityRepository.findById(id).orElseThrow();
        entity.setReviewsCount(entity.getReviewsCount() + 1);
        entity.setLastReviewed(LocalDate.now());
        learningEntityRepository.save(entity);
    }

    public LearningEntitiesTodayDto today() {
        var repeatSettings = repeatSettingService.getSettings();
        var repeatSettingsMap = getRepeatSettingsMap(repeatSettings);
        orderValidity(repeatSettingsMap);
        var entities = new ArrayList<LearningEntity>();
        for (var entry : repeatSettingsMap.entrySet()) {
            entities.addAll(learningEntityRepository.findByReviewsCountAndLastReviewedIsLessThanEqual(
                    entry.getKey(), LocalDate.now().minusDays(entry.getValue())));
        }
        var durationSetting = durationSettingService.getSettings();
        return new LearningEntitiesTodayDto(
                durationSetting.getDuration(),
                durationSetting.getDelay(),
                learningEntityMapper.toDtoList(entities)
        );
    }

    private Map<Integer, Integer> getRepeatSettingsMap(List<RepeatSetting> repeatSettings) {
        var map = new HashMap<Integer, Integer>();
        for (var setting : repeatSettings) {
            map.put(setting.getReviewOrder(), setting.getRepeatDay());
        }
        return map;
    }

    private void orderValidity(Map<Integer, Integer> map) {
        var orders = map.keySet();
        for (var i = 0; i < orders.size(); i++) {
            if (!orders.contains(i + 1)) {
                throw new RuntimeException("Repeat settings are not valid");
            }
        }
    }

    public Page<LearningEntityDto> paginatedAll(String searchingString, Integer page, Integer size) {
        var entities = learningEntityRepository.findByLearningPassageSortedPageable(searchingString,
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "learningTerm")));
        return entities.map(learningEntityMapper::toDto);
    }
}
