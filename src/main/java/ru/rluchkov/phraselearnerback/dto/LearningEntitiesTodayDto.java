package ru.rluchkov.phraselearnerback.dto;

import java.util.List;

public record LearningEntitiesTodayDto(
        Integer duration,
        Integer delay,
        List<LearningEntityDto> learningEntities) {
}
