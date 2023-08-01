package ru.rluchkov.phraselearnerback.dto;

import java.time.LocalDate;
import java.util.UUID;

public record LearningEntityDto(
        UUID id,
        String learningPassage,
        String learningTerm,
        LocalDate lastReviewed,
        Integer reviewsCount,
        String comment) {
}
