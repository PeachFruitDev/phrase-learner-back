package ru.rluchkov.phraselearnerback.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.rluchkov.phraselearnerback.dto.LearningEntityDto;
import ru.rluchkov.phraselearnerback.entities.LearningEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LearningEntityMapper {

    @Mapping(source = "id", target = "id")
    LearningEntityDto toDto(LearningEntity learningEntity);

    List<LearningEntityDto> toDtoList(List<LearningEntity> learningEntities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "lastReviewed", ignore = true),
            @Mapping(target = "reviewsCount", ignore = true)
    })
    LearningEntity toEntity(LearningEntityDto learningEntityDto);
}
